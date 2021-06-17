package lab3.pages;

import lab3.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static lab3.Util.timeOut;

public class MarketingPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static MarketingPage marketingPage;
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Configuration.getProperty("startPage"));
        startPage = new StartPage(driver);
        marketingPage = new MarketingPage(driver);

    }

    @AfterAll
    public static void close() {
        driver.quit();
    }


    @Test
    @Order(1)
    public void marketingPageTest() throws InterruptedException {
        startPage.getMainPageLink().click();
        timeOut(2);
        startPage.getMarketingLink().click();
        timeOut(2);
        Assertions.assertTrue(driver.getCurrentUrl().contains("mailchimp.com/marketing-platform/"));

        Assertions.assertTrue(marketingPage.getOpeningLine().getText().contains("Create better campaigns with Mailchimp"));
        timeOut(1);

        marketingPage.getFeaturesLink().click();
        timeOut(2);
        Assertions.assertTrue(driver.getCurrentUrl().contains("mailchimp.com/features/automations/customer-journey-builder/"));


    }

}
