package com.Model;
import java.util.ArrayList;
import java.util.List;

//Admin Database for storing all Admin objects (containing usernames and passwords per admin)
//Singleton used here to ensure only one instance of this exists
public final class AdminDatabase
{
    private static AdminDatabase INSTANCE = null;
    public final List<Admin> adminDetails = new ArrayList<Admin>();

    public static AdminDatabase getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new AdminDatabase();
        }
        return INSTANCE;
    }
}