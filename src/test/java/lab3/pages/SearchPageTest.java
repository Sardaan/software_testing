package lab3.pages;

import lab3.exceptions.InvalidPropertiesException;
import lab3.utils.Configuration;
import lab3.utils.Constants;
import lab3.utils.Context;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static lab3.utils.Util.timeOut;


public class SearchPageTest {
    private static SearchPage searchPage;
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
    public void searchApiTest() throws InterruptedException {
        for (int i = 0; i < driverList.size(); i++) {

            driverList.get(i).manage().window().maximize();
            driverList.get(i).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driverList.get(i).get(Configuration.getProperty("startPage"));
            searchPage = new SearchPage(driverList.get(i));
            searchPage.getSearchLink().click();
            searchPage.inputSearchField("api");
            searchPage.getSearchButton().click();
            Assertions.assertTrue(searchPage.getResultText().getText().contains("Mailchimp Developer"));
        }
    }


    @Test
    public void searchEmailTemplateTest() throws InterruptedException {
        for (int i = 0; i < driverList.size(); i++) {

            driverList.get(i).manage().window().maximize();
            driverList.get(i).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driverList.get(i).get(Configuration.getProperty("startPage"));
            searchPage = new SearchPage(driverList.get(i));
            searchPage.getSearchLink().click();
            timeOut(2);
            searchPage.getEmailTemplates().click();
            timeOut(3);
            searchPage.getSearchResults().click();
            Assertions.assertTrue(driverList.get(i).getCurrentUrl().contains("mailchimp.com/features/email-templates/"));
//            Assertions.assertTrue(searchPage.getResultText().getText().contains("Mailchimp Developer"));
        }
    }

    @Test
    public void filterResultTest() throws InterruptedException {
        for (int i = 0; i < driverList.size(); i++) {

            driverList.get(i).manage().window().maximize();
            driverList.get(i).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driverList.get(i).get(Configuration.getProperty("startPage"));
            searchPage = new SearchPage(driverList.get(i));
            searchPage.getSearchLink().click();
            timeOut(2);
            searchPage.getNewsletter().click();
            timeOut(3);
            driverList.get(i).navigate().to("https://mailchimp.com/search/?q=newsletter");
            timeOut(2);
            searchPage.getTutorialsFilter().click();
            Assertions.assertTrue(searchPage.getResult().getText().contains("36"));
        }
    }
}
