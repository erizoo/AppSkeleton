package com.bastau.app.data.models;

import com.google.gson.annotations.SerializedName;

public class RequestAuth {

    @SerializedName("login")
    private String login;
    @SerializedName("password")
    private String password;

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
