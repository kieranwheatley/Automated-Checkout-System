import com.Model.Product;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.*;

public class StockControllerTest {


    @Before
    public void setUp()
    {
        Product testProduct = new Product();

    }

    @org.junit.Test
    public void displayBasket() throws Exception {
    }

    @org.junit.Test
    public void displayLowStock() throws Exception {
    }

    @org.junit.Test
    public void addProductToBasket() throws Exception {
    }

    @org.junit.Test
    public void priceCalculation() throws Exception {
        Product testProduct;
        testProduct = new Product();
        double price = testProduct.getSalePrice();
        //assertEquals(1.99, , null);

    }

    @org.junit.Test
    public void barcodeScanner() throws Exception {
    }
}