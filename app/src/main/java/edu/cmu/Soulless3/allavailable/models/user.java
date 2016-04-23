package edu.cmu.Soulless3.allavailable.models;

/**
 * Created by nidhish on 4/15/16.
 */
public abstract class user {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
