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


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductTitleIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(productsTitle));
        productsTitle.isDisplayed();
    }

}