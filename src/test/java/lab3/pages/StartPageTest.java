package lab3.pages;

import lab3.Configuration;
import lab3.pages.StartPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static lab3.Util.timeOut;

public class StartPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static String[] handles;

    @BeforeAll
    public static void init() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", Configuration.getProperty("chromeDriver"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Configuration.getProperty("startPage"));
        startPage = new StartPage(driver);
        handles = new String[driver.getWindowHandles().size()];
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }

    @Test
    public void internalUrlsCheck() throws InterruptedException {

        startPage.getPricingLink().click();
        timeOut(2);
        Assertions.assertTrue(driver.getCurrentUrl().contains("mailchimp.com/pricing/marketing/"));

        startPage.getMainPageLink().click();
        timeOut(2);
        startPage.getMarketingLink().click();
        timeOut(2);
        Assertions.assertTrue(driver.getCurrentUrl().contains("mailchimp.com/marketing-platform/"));

        startPage.getMainPageLink().click();
        timeOut(2);
        startPage.getWebsitesLink().click();
        timeOut(2);
        Assertions.assertTrue(driver.getCurrentUrl().contains("mailchimp.com/get-your-business-online/"));

    }
}
