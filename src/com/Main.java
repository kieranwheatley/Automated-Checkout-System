package com;
import com.*;
import com.Controller.UserViewController;
import com.View.TillView;

public class Main
{
    public static void main(String[] args)
    {
        UserViewController controller = new UserViewController();
        controller.loadGUI();
        controller.till.setVisible(true);
    }
}
