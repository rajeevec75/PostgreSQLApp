package com.PostgreSQLApp.service;

import com.PostgreSQLApp.model.User;
import com.PostgreSQLApp.results.DataResult;
import com.PostgreSQLApp.results.LoginResponse;
import com.PostgreSQLApp.results.Result;
import java.util.List;

public interface UserService {

    public DataResult<List<User>> getAllUsers(int pageNumber, int pageSize);

    public DataResult<User> getUserById(Integer id);

    public DataResult<User> createUser(User user);

    public DataResult<User> updateUser(Integer id, User user);

    public Result deleteUser(Integer id);

    public LoginResponse login(String jsonData);

    public DataResult<User> changePassword(String jsonData);
}
