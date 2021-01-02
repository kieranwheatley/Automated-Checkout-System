import javax.swing.*;
import java.awt.*;

public class frmKioskMain extends JFrame{
    private JPanel JPanelBackground;
    private JButton btnAdmin;
    private JLabel lblHeader;
    private JTextArea txtBasket;
    private JTextArea txtStock;
    private JLabel lblStock;
    private JLabel lblBasket;
    private JButton btnManualSelect;
    private JButton btnScanBarcode;
    private JButton btnPayment;
    private JLabel lblTotalCost;

    public frmKioskMain() {
        setContentPane(JPanelBackground);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        pack();
    }

    public static void main(String[] args)
    {
        frmKioskMain till = new frmKioskMain();
        till.setVisible(true);
        till.setTitle("Automated Checkout System");
        till.setResizable(false);
    }

}
