package Steps;

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

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

    @After
    public void close_browser() {
        driver.quit();
    }

}
