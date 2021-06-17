package lab3.pages;

import lab3.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

import static lab3.Util.timeOut;


public class LoginPageTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static LoginPage loginPage;
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

//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }

    @Test
    public void loginWrongTest() throws InterruptedException {
        driver.get(Configuration.getProperty("startPage"));
        startPage = new StartPage(driver);
        startPage.getLoginLink().click();
        loginPage=new LoginPage(driver);
        loginPage.getLoginButton().click();
        timeOut(2);
        Assertions.assertTrue(loginPage.getErrorMsg().getText().contains("You did not enter a username or a password."));
        timeOut(1);
    }

    @Test
    public void loginCorrectTest() throws InterruptedException {
        driver.get(Configuration.getProperty("startPage"));
        startPage = new StartPage(driver);
        startPage.getLoginLink().click();
        loginPage=new LoginPage(driver);
        loginPage.inputLogin(Configuration.getProperty("login"));
        loginPage.inputPassword(Configuration.getProperty("password"));
        loginPage.getLoginButton().click();
        timeOut(2);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://us6.admin.mailchimp.com/login/"));
    }
}
