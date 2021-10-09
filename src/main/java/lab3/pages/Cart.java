package lab3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends Page{


    @FindBy(xpath="/html/body/header/nav/div[2]/a[2]")
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

    public WebElement getPricingLink() {
        pricingLink = driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]"));
        pricingLink.sendKeys("Selenium");

        return pricingLink;
    }

//    public WebElement getPricingLink() {
//        return pricingLink;
//    }

//    public WebElement getAddItemToCartButton() {
//        return addItemToCartButton;
//    }

    public WebElement getAddItemToCartButton() {

        addItemToCartButton = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div[2]/div[2]/div[2]/div/div[4]/a"));
        addItemToCartButton.sendKeys("Selenium");

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
        super(driver);
    }


}
