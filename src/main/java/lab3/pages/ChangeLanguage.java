package lab3.pages;

import lab3.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.List;

public class ChangeLanguage {

    private WebDriver driver;

//    @FindBy(xpath="/html/body/footer/div[2]/div/div/div[1]/div[2]/select")
//    private WebElement languageField;
    @FindBy(xpath="/html/body/main/section[1]/div/div/div/h1")
    private WebElement resultText;

    @FindBy(xpath="/html/body/footer/div[2]/div/div/div[1]/div[2]/select")
    private WebElement languageLink;


    @FindBy(xpath="/html/body/footer/div[2]/div/div/div[1]/div[2]/select/option[2]")
    private WebElement option2Button;

    private Select languageSelect;



    public ChangeLanguage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        this.languageSelect = new Select(driver.findElement(By.id("languagePicker")));
    }

    public Select getLanguageSelect() {
        return languageSelect;
    }

    public WebElement getLanguageLink() {
        return languageLink;
    }

    public WebElement getOption2Button() {
        return option2Button;
    }

    public WebElement getResultText() {
        return resultText;
    }

    public void selectLanguage(String language){
        languageSelect.selectByVisibleText(language);

    }
}
