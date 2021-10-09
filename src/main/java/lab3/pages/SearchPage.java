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
    @FindBy(xpath = "/html/body/header/div[2]/div[1]/div/div/section/ul/li[1]/a")
    private WebElement emailTemplates;
    @FindBy(xpath = "/html/body/header/div[2]/div[1]/div/div/div/div[1]/h2/a")
    private WebElement searchResults;

    @FindBy(xpath = "/html/body/header/div[2]/div[1]/div/div/section/ul/li[2]/a")
    private WebElement newsletter;
    @FindBy(xpath = "/html/body/header/div[2]/div[1]/div/div/a")
    private WebElement seeAllResults;
    @FindBy(xpath = "/html/body/main/div/div[2]/div/div[1]/ul/li[4]/a")
    private WebElement tutorialsFilter;
    @FindBy(xpath = "/html/body/main/div/div[2]/div/div[3]/div/div[1]/p/strong[1]")
    private WebElement result;


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

    public WebElement getEmailTemplates() {
        return emailTemplates;
    }

    public WebElement getSearchResults() {
        return searchResults;
    }

    public WebElement getNewsletter() {
        return newsletter;
    }

    public WebElement getSeeAllResults() {
        return seeAllResults;
    }

    public WebElement getTutorialsFilter() {
        return tutorialsFilter;
    }

    public WebElement getResult() {
        return result;
    }
}
