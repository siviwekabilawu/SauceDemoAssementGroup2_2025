package Steps;

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class StepsDefinition extends Base {

    @Given("I am in the login page")
    public void i_am_in_the_login_page() {


    }

    @When("I enter a valid username {string} and a valid password {string}")
    public void i_enter_a_valid_username_and_a_valid_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();

    }

    @Then("I am logged in successfully")
    public void i_am_logged_in_successfully() {
        landingPage.verifyProductTitleIsDisplayed();

    }

    @When("I add an item to the cart")
    public void i_add_an_item_to_the_cart() {

        landingPage.clickAddToCartButton();

    }

    @When("I click on the cart button")
    public void i_click_on_the_cart_button() {

        landingPage.clickCartButton();

    }

    @Then("I verify that the item is in the cart")
    public void i_verify_that_the_item_is_in_the_cart() {
        landingPage.confirmAddedToCart();

    }

    @When("I click on the checkout button")
    public void i_click_on_the_checkout_button() {

        yourCartPage.clickCheckoutButton();

    }


    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    @After
    public void close_browser() {
        driver.quit();
    }

    @Then("The your information page is displayed")
    public void theYourInformationPageIsDisplayed() {
        informationPage.verifyYourInformationHeadingIsDisplayed();
    }
}
