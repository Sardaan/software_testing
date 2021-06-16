package lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver driver;
    @FindBy(xpath="/html/body/header/nav/ul/li[1]/a")
    private WebElement searchLink;
    @FindBy(xpath="/html/body/header/div[2]/div[1]/div/div/form/input")
    private WebElement searchField;
    @FindBy(xpath="/html/body/header/div[2]/div[1]/div/div/form/button")
    private WebElement searchButton;
    @FindBy(xpath = "/html/body/header/div[2]/div[1]/div/div/div/div[1]/h2/a")
    private WebElement resultText;


    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public WebElement getSearchLink() {
        return searchLink;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getResultText() {
        return resultText;
    }

    public void inputSearchField(String text){
        searchField.sendKeys(text);
    }

}
