package com.PostgreSQLApp.results;

import com.PostgreSQLApp.model.User;
import java.util.ArrayList;

public class LoginResponse {

    private boolean apiStatus;
    private ArrayList<LoginError> loginErrors;
    private String refreshToken;
    private String token;
    private User user;

    public LoginResponse() {
    }

    public LoginResponse(boolean apiStatus) {
        this.apiStatus = apiStatus;
    }

    public boolean isApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(boolean apiStatus) {
        this.apiStatus = apiStatus;
    }

    public ArrayList<LoginError> getLoginErrors() {
        return loginErrors;
    }

    public void setLoginErrors(ArrayList<LoginError> loginErrors) {
        this.loginErrors = loginErrors;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
