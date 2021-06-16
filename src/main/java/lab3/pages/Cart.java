package lab3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Cart {

    private WebDriver driver;

    @FindBy(xpath="/html/body/header/nav/div[3]/a[2]")
    private WebElement pricingLink;
    @FindBy(xpath="/html/body/main/div/div/div[1]/div[2]/div[2]/div[2]/div/div[4]/a")
    private WebElement addItemToCartButton;
    @FindBy(xpath="/html/body/header/nav/ul/li[2]/a")
    private WebElement cartButton;
    @FindBy(xpath="/html/body/header/nav/div[2]/div[2]/div/div[2]/ul/li/div[2]/h5/a")
    private WebElement cartText;
    @FindBy(xpath="/html/body/header/nav/div[2]/div[2]/div/div[2]/ul/li/div[2]/a")
    private WebElement deleteItemButton;
    @FindBy(xpath="/html/body/header/nav/div[2]/div[2]/div/h3")
    private WebElement cartEmptyText;

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getPricingLink() {
        return pricingLink;
    }

    public WebElement getAddItemToCartButton() {
        return addItemToCartButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getCartText() {
        return cartText;
    }

    public WebElement getDeleteItemButton() {
        return deleteItemButton;
    }

    public WebElement getCartEmptyText() {
        return cartEmptyText;
    }

    public Cart(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }


}
