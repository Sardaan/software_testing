package lab3.pages;

import lab3.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static lab3.Util.timeOut;

public class CartTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static Cart cart;
    private static String driverType;


    @BeforeAll
    public static void init() {
        driverType = Configuration.getProperty("driverType");
        if (driverType.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", Configuration.getProperty("chromeDriver"));
            driver = new ChromeDriver();
        }else {
            driver = new FirefoxDriver();
            System.setProperty("webdriver.firefox.driver", Configuration.getProperty("firefoxDriver"));
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Configuration.getProperty("startPage"));
        startPage = new StartPage(driver);
        cart = new Cart(driver);
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }

    @Test
    public void SignUpTest() throws InterruptedException {
        cart.getPricingLink().click();
        timeOut(2);
        cart.getAddItemToCartButton().click();
        timeOut(2);
        Assertions.assertTrue(cart.getCartText().getText().contains("Standard Plan"));
        cart.getDeleteItemButton().click();
        Assertions.assertTrue(cart.getCartEmptyText().getText().contains("Your cart is empty— for now."));

    }
}
