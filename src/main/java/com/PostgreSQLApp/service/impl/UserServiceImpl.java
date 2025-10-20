package com.PostgreSQLApp.service.impl;

import com.PostgreSQLApp.model.User;
import com.PostgreSQLApp.repository.UserRepository;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.ErrorDataResult;
import com.PostgreSQLApp.results.ErrorResult;
import com.PostgreSQLApp.results.LoginError;
import com.PostgreSQLApp.results.LoginResponse;
import com.PostgreSQLApp.results.Result;
import com.PostgreSQLApp.results.SuccessDataResult;
import com.PostgreSQLApp.results.SuccessResult;
import com.PostgreSQLApp.service.UserService;
import com.PostgreSQLApp.util.AESEncryptionUtil;
import com.PostgreSQLApp.util.JwtUtil;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public DataResult<List<User>> getAllUsers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<User> userPage = userRepository.findAll(pageable);
        List<User> users = userPage.getContent();

        return new DataResult<>(users, true, "Users retrieved successfully");
    }

    @Override
    public DataResult<User> getUserById(Integer id) {
        Optional<User> optUser = this.userRepository.findById(id);
        if (optUser.isEmpty()) {
            return new ErrorDataResult<>("User not found with ID: " + id);
        }
        return new SuccessDataResult<>(optUser.get(), "User retrieved successfully");
    }

    @Override
    public DataResult<User> createUser(User user) {
        try {
            // Hash the raw password
            String rawPassword = user.getPassword(); // Assume raw password is set
            String hashedPassword = AESEncryptionUtil.encrypt(rawPassword);
            user.setPassword(hashedPassword);

            // Save user
            User savedUser = userRepository.save(user);
            if (savedUser == null) {
                return new ErrorDataResult<>("User creation failed.");
            }

            return new SuccessDataResult<>(savedUser, "User created successfully.");

        } catch (DataIntegrityViolationException ex) {
            // Extract the field causing the constraint violation
            String message = extractConstraintField(ex);
            return new ErrorDataResult<>("Constraint violation on field: " + message);

        } catch (Exception e) {
            return new ErrorDataResult<>("Error creating user: " + e.getMessage());
        }
    }

    private String extractConstraintField(Exception e) {
        Throwable rootCause = org.apache.commons.lang3.exception.ExceptionUtils.getRootCause(e);
        if (rootCause != null && rootCause.getMessage() != null) {
            String msg = rootCause.getMessage();

            // Try to detect a constraint violation on a specific field (e.g., unique index or FK constraint)
            if (msg.contains("account_user_email_key")) {
                return "email (duplicate)";
            } else if (msg.contains("account_user_external_reference_key")) {
                return "externalReference (duplicate)";
            } else if (msg.contains("userprofile_user_default_billing_addr")) {
                return "defaultBillingAddressId (invalid FK)";
            } else if (msg.contains("userprofile_user_default_shipping_addr")) {
                return "defaultShippingAddressId (invalid FK)";
            }
            // Add more mappings as needed
            return msg;
        }
        return "unknown field";
    }

    @Override
    public DataResult<User> updateUser(Integer id, User user) {
        // Get existing user wrapped in DataResult
        DataResult<User> existingResult = getUserById(id);

        if (!existingResult.isSuccess()) {
            // Return the error result if user not found
            return new ErrorDataResult<>("User not found with ID: " + id);
        }

        User existing = existingResult.getData();

        // Ensure the ID stays the same
        user.setId(existing.getId());

        // Save updated user
        User updatedUser = userRepository.save(user);

        // Return success result with updated user
        return new SuccessDataResult<>(updatedUser, "User updated successfully");
    }

    @Override
    public Result deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            return new ErrorResult("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
        return new SuccessResult("User deleted successfully");
    }

    @Override
    public LoginResponse login(String jsonData) {
        LoginResponse loginResponse = new LoginResponse();
        JSONObject jsonObject = new JSONObject(jsonData);

        // Validate required fields
        if (!jsonObject.has("email") || !jsonObject.has("password")) {
            return buildErrorResponse();
        }

        String email = jsonObject.getString("email");
        String rawPassword = jsonObject.getString("password");

        // Find user by email
        Optional<User> userOpt = this.userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            return buildErrorResponse();
        }

        User user = userOpt.get();

        try {
            // Decrypt stored AES password
            String decryptedStoredPassword = AESEncryptionUtil.decrypt(user.getPassword());

            // Check password
            if (!decryptedStoredPassword.equals(rawPassword)) {
                return buildErrorResponse();
            }

            // Generate JWT token valid for 1 minute
            String jwtToken = JwtUtil.generateToken(email);

            // Successful login response
            loginResponse.setApiStatus(true);
            loginResponse.setUser(user);
            loginResponse.setToken(jwtToken);
            loginResponse.setRefreshToken("dummy-refresh-token-abcde");
            loginResponse.setLoginErrors(null);

        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return buildErrorResponse();
        }

        return loginResponse;
    }

    private LoginResponse buildErrorResponse() {
        LoginResponse response = new LoginResponse();
        response.setApiStatus(false);

        ArrayList<LoginError> loginErrors = new ArrayList<>();
        loginErrors.add(new LoginError("email/password", "Invalid email or password"));
        response.setLoginErrors(loginErrors);
        response.setToken(null);
        response.setRefreshToken(null);
        response.setUser(null);

        return response;
    }

    @Override
    public DataResult<User> changePassword(String jsonData) {
        try {
            // Parse the JSON string
            JSONObject jsonObject = new JSONObject(jsonData);
            String email = jsonObject.getString("email");
            String newPassword = jsonObject.getString("password");

            // Find user by email
            Optional<User> optUser = this.userRepository.findByEmail(email);
            if (optUser.isEmpty()) {
                return new ErrorDataResult<>("User not found with email: " + email);
            }

            // Encrypt the password using PBKDF2
            String hashedPassword = AESEncryptionUtil.encrypt(newPassword);

            // Update and save user
            User user = optUser.get();
            user.setPassword(hashedPassword);
            userRepository.save(user);

            return new SuccessDataResult<>(user, "Password updated successfully.");
        } catch (Exception e) {
            return new ErrorDataResult<>("Error updating password: " + e.getMessage());
        }
    }

}
