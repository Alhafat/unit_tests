package org.example;

public class User {

    String name;
    String password;

    String status;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        return false;
    }

}