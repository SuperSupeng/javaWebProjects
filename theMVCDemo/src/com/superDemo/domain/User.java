package com.superDemo.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private String username;
    private String password;
    private String email;
    private Date bitrhday;

    public User(){}

    public User(String username, String password, String email, Date bitrhday) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.bitrhday = bitrhday;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBitrhday() {
        return bitrhday;
    }

    public void setBitrhday(Date bitrhday) {
        this.bitrhday = bitrhday;
    }
}
