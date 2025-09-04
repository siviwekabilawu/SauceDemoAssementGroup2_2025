package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    WebElement verifyloginpage_h4;

    @FindBy(id = "user-name")
    WebElement username_id;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(id = "login-button")
    WebElement login_button_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(username_id));
        username_id.sendKeys(username);
    }

    public void enterPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(password_id));
        password_id.sendKeys(password);
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(login_button_id));
        login_button_id.click();
    }
}
