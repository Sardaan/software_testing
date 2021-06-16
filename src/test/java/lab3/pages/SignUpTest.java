package lab3.pages;

import lab3.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static lab3.Util.timeOut;

public class SignUpTest {
    private static WebDriver driver;
    private static StartPage startPage;
    private static SignUpPage signUpPage;


    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", Configuration.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(Configuration.getProperty("startPage"));
        startPage = new StartPage(driver);
        signUpPage=new SignUpPage(driver);
    }

    @AfterAll
    public static void close() {
        driver.quit();
    }

    @Test
    public void SignUpTest() throws InterruptedException {
        startPage.getSignUpLink().click();
        timeOut(2);
        signUpPage.inputEmail(Configuration.getProperty("email"));
        signUpPage.inputLogin(Configuration.getProperty("login"));
        signUpPage.inputPassword(Configuration.getProperty("password"));
        signUpPage.getSignUpButton().click();
        timeOut(2);
        Assertions.assertTrue(signUpPage.getErrorMsg().getText().contains("Another user with this username already exists. Maybe it's your evil twin. Spooky."));

    }
}
