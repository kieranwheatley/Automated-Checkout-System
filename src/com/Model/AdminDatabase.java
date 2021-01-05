package com.Model;
import java.util.ArrayList;
import java.util.List;

public final class AdminDatabase
{
    private static AdminDatabase INSTANCE = null;
    public List<Admin> adminDetails = new ArrayList<Admin>();
    public Integer holder = 0;

    public static AdminDatabase getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new AdminDatabase();
        }
        return INSTANCE;
    }
}