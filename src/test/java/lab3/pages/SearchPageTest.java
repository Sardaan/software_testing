package lab3.pages;

import lab3.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static lab3.Util.timeOut;

public class SearchPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static SearchPage searchPage;


    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", Configuration.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Configuration.getProperty("startPage"));
        startPage = new StartPage(driver);
        searchPage = new SearchPage(driver);
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }

    @Test
    public void SignUpTest() throws InterruptedException {
        searchPage.getSearchLink().click();
        timeOut(2);
        searchPage.inputSearchField("api");
        searchPage.getSearchButton().click();
        timeOut(2);
        Assertions.assertTrue(searchPage.getResultText().getText().contains("Mailchimp Developer"));
    }
}