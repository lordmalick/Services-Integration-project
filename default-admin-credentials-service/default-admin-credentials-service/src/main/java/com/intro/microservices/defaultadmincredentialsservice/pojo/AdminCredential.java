package com.intro.microservices.defaultadmincredentialsservice.pojo;

public class AdminCredential {
    private String login;
    private String password;

    public AdminCredential (){}
    public AdminCredential(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
