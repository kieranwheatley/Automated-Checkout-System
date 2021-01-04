package com.Controller;
import com.Controller.*;
import com.Model.*;
import com.View.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminLoginController
{
    public void loadAdmins()
    {
        try {
            //Setting up the filepath and input stream
            File inputData = new File("src/resources/adminLogin.txt");
            Scanner filereader = new Scanner(inputData);
            //Keep running until the file is empty
            while (filereader.hasNextLine()) {
                //Read each line in and assign them to a variables
                String username = filereader.nextLine();
                String password = filereader.nextLine();
                //Create admin object to store username and password
                Admin tempAdmin = new Admin(username, password);
                //Add the newly created Product object to the Stock Database for access within the till
                AdminDatabase.getInstance().adminDetails.add(tempAdmin);
            }
            //Close the filereader once all details have been read in (to prevent problems)
            filereader.close();
        }
        //Catch the file not being found.
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(TillView.getFrames()[0], "Admin details could not be loaded. Sign-in will be unavailable. Please speak to a Systems Admin.", "Error: File Exception.", JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean checkAdmin(String username, String password)
    {
        boolean exists = false;
        for (int user = 0; user < AdminDatabase.getInstance().adminDetails.size(); user++)
        {
            String fileUsername = AdminDatabase.getInstance().adminDetails.get(user).getUsername();
            String filePassword = AdminDatabase.getInstance().adminDetails.get(user).getPassword();
            if(fileUsername == username && filePassword == password)
            {
                exists = true;
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(TillView.getFrames()[0], "Username and/or password are incorrect. Please try again.", "Login Failed.", JOptionPane.ERROR_MESSAGE);
                exists = false;
            }

        }
        return exists;
    }
}
