package lab3.pages;

import lab3.exceptions.InvalidPropertiesException;
import lab3.utils.Configuration;
import lab3.utils.Constants;
import lab3.utils.Context;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignUpTest {
    private static StartPage startPage;
    private static SignUpPage signUpPage;
    public Context context;
    public List<WebDriver> driverList;

    @BeforeEach
    public void init() {
        context = new Context();
        driverList = new ArrayList<>();
        try {
            Configuration.getInstance().reading(context);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        if (context.getGeckodriver() != null) {
            System.setProperty(Constants.WEBDRIVER_FIREFOX_DRIVER, context.getGeckodriver());
            driverList.add(new FirefoxDriver());
        }
        if (context.getChromedriver() != null) {
            System.setProperty(Constants.WEBDRIVER_CHROME_DRIVER, context.getChromedriver());
            driverList.add(new ChromeDriver());
        }
        if (driverList.isEmpty()) throw new InvalidPropertiesException();

    }

    @AfterEach
    public void close() {
        driverList.forEach(WebDriver::quit);
    }


    @Test
    public void SignUpTest() throws InterruptedException {
        for (int i = 0; i < driverList.size(); i++) {
            driverList.get(i).manage().window().maximize();
            driverList.get(i).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driverList.get(i).get(Configuration.getProperty("startPage"));
            startPage = new StartPage(driverList.get(i));
            signUpPage = new SignUpPage(driverList.get(i));

            startPage.getSignUpLink().click();
            signUpPage.inputEmail(Configuration.getProperty("email"));
            signUpPage.inputLogin(Configuration.getProperty("login"));
            signUpPage.inputPassword(Configuration.getProperty("password"));
            signUpPage.getSignUpButton().submit();
            Assertions.assertTrue(signUpPage.getErrorMsg().getText().contains("Another user with this username already exists. Maybe it's your evil twin. Spooky."));
        }
    }
}
