package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeLanguage {

    private WebDriver driver;

    @FindBy(xpath="/html/body/footer/div[2]/div/div/div[1]/div[2]/select")
    private WebElement languageField;
    @FindBy(xpath="/html/body/main/section[1]/div/div/div/h1")
    private WebElement resultText;

    @FindBy(xpath="/html/body/footer/div[3]/div/div/div[1]/div[2]/select")
    private WebElement languageLink;
    @FindBy(xpath="/html/body/footer/div[3]/div/div/div[1]/div[2]/select/option[2]")
    private WebElement option2Button;

    public ChangeLanguage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public WebElement getOption2Button() {
        return option2Button;
    }


}
