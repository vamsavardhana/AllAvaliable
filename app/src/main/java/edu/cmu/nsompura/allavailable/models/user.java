package edu.cmu.nsompura.allavailable.models;

/**
 * Created by nidhish on 4/15/16.
 */
public class user {
    String username;
    private String password;
    String andrewid;
    String phoneno;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAndrewId(){
        return andrewid;
    }

    public String getPhoneNumber(){
        return phoneno;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAndrewId(String andrewid){this.andrewid=andrewid;}

    public void setPhoneNumber(String phoneno){this.phoneno=phoneno;}
}
