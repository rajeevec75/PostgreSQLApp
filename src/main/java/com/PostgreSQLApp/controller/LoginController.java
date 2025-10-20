package com.PostgreSQLApp.controller;

import com.PostgreSQLApp.results.LoginResponse;
import com.PostgreSQLApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody String jsonData) {
        LoginResponse response = this.userService.login(jsonData);
        return ResponseEntity.ok(response);
    }

}
