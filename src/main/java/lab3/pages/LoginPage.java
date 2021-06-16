package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    @FindBy(xpath="//*[@id=\"username\"]")
    private WebElement loginField;
    @FindBy(xpath="//*[@id=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/main/div/div/div/form/fieldset/div[4]/button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"empty-error\"]/div/div/div[2]/p")
    private WebElement errorMsg;
    @FindBy(xpath = "/html/body/div[3]/div[3]/main/div[1]/h1")
    private WebElement welcomeLine;
    @FindBy(xpath = "/html/body/div[28]/div/div/div/div/div[1]/div[2]/ul/li[5]/a")
    private WebElement logOutButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }


    public WebElement getLoginField(){
        return loginField;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

    public WebElement getLoginButton(){
        return loginButton;
    }

    public WebElement getErrorMsg(){
        return errorMsg;
    }

    public WebElement getWelcomeLine(){
        return welcomeLine;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
}
