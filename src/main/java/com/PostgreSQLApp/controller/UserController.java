package com.PostgreSQLApp.controller;

import com.PostgreSQLApp.model.User;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.ErrorResult;
import com.PostgreSQLApp.results.Result;
import com.PostgreSQLApp.service.UserService;
import com.PostgreSQLApp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(
            @RequestHeader(value = "Authorization", required = false) String token,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        // Check if Authorization header is missing
        if (token == null || token.isEmpty()) {
            return ResponseEntity.ok(new ErrorResult("Authorization header is missing. Please include 'Bearer <token>' in headers."));
        }

        // Required: Handle 'Bearer <token>' format
        if (!token.startsWith("Bearer ")) {
            return ResponseEntity.ok(new ErrorResult("Invalid token format. Token must start with 'Bearer '."));
        }

        // Extract token part
        token = token.substring(7);

        //  Validate token
        if (!JwtUtil.validateToken(token)) {
            return ResponseEntity.ok(new ErrorResult("Session expired or invalid token. Please log in again."));
        }

        DataResult<List<User>> result = userService.getAllUsers(pageNumber, pageSize);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable Integer id) {

        // Check if Authorization header is missing
        if (token == null || token.isEmpty()) {
            return ResponseEntity.ok(new ErrorResult("Authorization header is missing. Please include 'Bearer <token>' in headers."));
        }

        // Required: Handle 'Bearer <token>' format
        if (!token.startsWith("Bearer ")) {
            return ResponseEntity.ok(new ErrorResult("Invalid token format. Token must start with 'Bearer '."));
        }

        // Extract token part
        token = token.substring(7);

        //  Validate token
        if (!JwtUtil.validateToken(token)) {
            return ResponseEntity.ok(new ErrorResult("Session expired or invalid token. Please log in again."));
        }
        DataResult<User> result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        DataResult<User> result = userService.createUser(user);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<User>> updateUser(@PathVariable Integer id, @RequestBody User user) {
        DataResult<User> result = this.userService.updateUser(id, user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteUser(@PathVariable Integer id) {
        Result result = this.userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody String jsonData) {
        DataResult<User> result = this.userService.changePassword(jsonData);
        return ResponseEntity.ok(result);
    }
}
