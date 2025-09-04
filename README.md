# Sauce Demo cucumber java assessment

This repository contains an automated testing framework for the Sauce Demo web application, built using Java, 
Cucumber, Maven and Selenium WebDriver. The framework is structured for maintainability and scalability, 
following best practices for BDD (Behavior-Driven Development).

## 📂 Project Structure

SauceDemoAssessmentGroup2_2025
│── pom.xml / build.gradle # Dependency & build management
│── README.md # Project documentation
│
├── src
│ ├── main
│ │ └── java
│ │ └── framework
│ │ ├── base
│ │ │ └── BaseTest.java # Base setup & teardown
│ │ │
│ │ ├── pages
│ │ │ └── LoginPage.java # Page Object for login page
│ │ │
│ │ ├── utils
│ │ │ └── BrowserFactory.java # Browser driver factory
│ │ │
│ │ └── config
│ │ └── ConfigReader.java # Read properties file
│ │
│ └── test
│ ├── java
│ │ ├── stepDefinitions
│ │ │ └── StepsDefinition.java # Step implementations
│ │ │
│ │ └── runners
│ │ └── Runner.java # Cucumber test runner
│ │
│ └── resources
│ ├── features
│ │ └── Login.feature # Gherkin scenarios
│ │
│ └── config.properties # Browser, URL, credentials
│
└── target / reports # Test reports output

Copy code

---

## ⚙️ Prerequisites

- **Java JDK 8+**
- **Maven**
- **IDE (IntelliJ IDEA / Eclipse / VS Code)**
- **Git**

Optional:
- **Allure / Extent Reports** for reporting

---

## 🚀 Setup & Execution

### 1. Clone the repository
```bash
git clone https://github.com/your-username/selenium-java-cucumber-framework.git
cd selenium-java-cucumber-framework
2. Install dependencies
bash
Copy code
mvn clean install
3. Run tests
Run all scenarios:

bash
Copy code
mvn test
Run by tag:

bash
Copy code
mvn test -Dcucumber.filter.tags="@Login"
🧪 Example Test Flow (SauceDemo Login)
🔹 Feature File (Login.feature)
gherkin
Copy code
Feature: SauceDemo Login

  @Login
  Scenario: Valid user login
    Given User is on SauceDemo login page
    When User enters valid username and password
    Then User should be redirected to the products page
🔹 Page Object (LoginPage.java)
java
Copy code
package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
🔹 Step Definition (StepsDefinition.java)
java
Copy code
package stepDefinitions;

import framework.pages.LoginPage;
import framework.utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;

public class StepsDefinition {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on SauceDemo login page")
    public void user_is_on_login_page() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the products page")
    public void user_redirected_to_products_page() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("inventory")) {
            throw new AssertionError("User not redirected to products page!");
        }
        driver.quit();
    }
}
🔹 Browser Factory (BrowserFactory.java)
java
Copy code
package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
🔹 Runner (Runner.java)
java
Copy code
package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {"pretty","html:target/cucumber-reports.html"},
    monochrome = true
)
public class Runner {
}
📊 Reports
Cucumber Reports: /target/cucumber-reports.html

Allure Reports (if integrated):

bash
Copy code
allure serve target/allure-results