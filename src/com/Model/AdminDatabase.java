package com.Model;
import java.util.ArrayList;
import java.util.List;

public final class AdminDatabase
{
    private static AdminDatabase single_instance = null;
    public List<Admin> adminDetails = new ArrayList<Admin>();
    public Integer holder = 0;

    public static AdminDatabase getInstance()
    {
        if (single_instance == null)
        {
            single_instance = new AdminDatabase();
        }
        return single_instance;
    }
}