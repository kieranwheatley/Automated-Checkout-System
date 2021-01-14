package com;
import com.Controller.UserViewController;

public class Main
{
    public static void main(String[] args)
    {
        UserViewController controller = new UserViewController();
        controller.loadGUI();
        controller.till.setVisible(true);
    }
}
