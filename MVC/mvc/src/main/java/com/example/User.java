package com.example;

public class User {
    private String un;
    private String ps;

    User(String un, String ps) {
        this.un = un;
        this.ps = ps;
    }

    public String getUsername() {
        return this.un;
    }

    public String getUserPassword() {
        return this.ps;
    }

    public boolean validate() {
        return un.equals("admin") && ps.equals("password");
    }
}
