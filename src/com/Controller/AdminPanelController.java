package com.Controller;

import com.Model.StockDatabase;
import com.View.AdminLogin;
import javax.swing.*;
import java.awt.*;

public class AdminPanelController
{
    public void checkStockLevels(DefaultListModel<String> defaultListModel)
    {
        defaultListModel.clear();
        for (int product = 0; product < StockDatabase.getInstance().stock.size(); product++)
        {
            if (StockDatabase.getInstance().stock.get(product).getStockLevel() <= StockDatabase.getInstance().stock.get(product).getMinimumOrderLevel())
            {
                defaultListModel.add(product, StockDatabase.getInstance().stock.get(product).getName());
            }
            else
            {
                break;
            }
        }
        JOptionPane.showMessageDialog(AdminLogin.getFrames()[0], defaultListModel, "Low stock levels! Please re-order.", JOptionPane.PLAIN_MESSAGE);
    }
}
