package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage {

    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton_id;


    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(checkoutButton_id));
        checkoutButton_id.click();

    }



}