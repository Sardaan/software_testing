package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;
    @FindBy(xpath="/html/body/div[2]/div[1]/div/main/div/div/form/fieldset/div[1]/div/input")
    private WebElement emailFeild;
    @FindBy(xpath="/html/body/div[2]/div[1]/div/main/div/div/form/fieldset/div[2]/div/input")
    private WebElement loginField;
    @FindBy(xpath="/html/body/div[2]/div[1]/div/main/div/div/form/fieldset/div[3]/div/div[2]/input")
    private WebElement passwordField;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/main/div/div/form/fieldset/div[4]/button")
    private WebElement signUpButton;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[2]/div/span")
    private WebElement errorMsg;


    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }


    public WebElement getLoginField(){
        return loginField;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

    public WebElement getSignUpButton(){
        return signUpButton;
    }

    public WebElement getErrorMsg(){
        return errorMsg;
    }

    public void inputEmail(String email){
        emailFeild.sendKeys(email);
    }

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
}
