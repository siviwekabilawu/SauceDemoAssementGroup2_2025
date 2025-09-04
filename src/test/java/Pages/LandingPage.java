package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    WebDriver driver;

    @FindBy(css = "span.title[data-test='title']")
    WebElement productsTitle;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeFromCartButton;

    @FindBy(className = "shopping_cart_link")
    WebElement emptyCart;

    @FindBy(className = "shopping_cart_badge")
    WebElement fullCart;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(productsTitle));
        productsTitle.isDisplayed();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void confirmAddedToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(fullCart));
        fullCart.isDisplayed();
    }

    public void clickCartButton() {
        fullCart.click();
    }

    public void clickRemoveFromCartButton() {
        removeFromCartButton.click();
    }

    public void confirmCartIsEmpty() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(emptyCart));
        emptyCart.isDisplayed();
    }



}