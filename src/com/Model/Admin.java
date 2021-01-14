package com.Model;

//Admin class. The admin objects are created for each admin account on the system. These are stored within the Admin Database
public class Admin
{
    String username;
    String password;

    public Admin(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
