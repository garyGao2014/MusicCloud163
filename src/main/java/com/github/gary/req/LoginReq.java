package com.github.gary.req;


public class LoginReq {
    private String username;
    private String password;
    private String rememberLogin;
    private String clientToken;
    private String csrf_token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberLogin() {
        return rememberLogin;
    }

    public void setRememberLogin(String rememberLogin) {
        this.rememberLogin = rememberLogin;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public String getCsrf_token() {
        return csrf_token;
    }

    public void setCsrf_token(String csrf_token) {
        this.csrf_token = csrf_token;
    }
}
