package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingPage {
    private WebDriver driver;
    @FindBy(xpath="/html/body/main/section[1]/div/div[1]/div[1]/h1")
    private WebElement openingLine;
    @FindBy(xpath="/html/body/main/section[2]/div/div/div/div[2]/a")
    private WebElement featuresLink;

    public MarketingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public WebElement getOpeningLine() {
        return openingLine;
    }

    public WebElement getFeaturesLink() {
        return featuresLink;
    }
}
