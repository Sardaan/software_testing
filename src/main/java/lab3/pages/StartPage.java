package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/header/nav/ul/li[2]/a")
    private WebElement loginLink;
    @FindBy(xpath = "/html/body/header/nav/ul/li[3]/a")
    private WebElement signUpLink;
    @FindBy(xpath = "/html/body/header/nav/div[2]/a[2]")
    private WebElement pricingLink;
    @FindBy(xpath = "/html/body/main/section[3]/div/div/div/div[2]/div[2]/a")
    private WebElement websitesLink;
    @FindBy(xpath = "/html/body/main/section[4]/div/div/div/div[2]/div[2]/a")
    private WebElement marketingLink;
    @FindBy(xpath = "/html/body/header/nav/div[1]/a")
    private WebElement mainPageLink;




    public StartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getMainPageLink() {
        return mainPageLink;
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getSignUpLink() {
        return signUpLink;
    }

    public WebElement getPricingLink() {
        return pricingLink;
    }


}
