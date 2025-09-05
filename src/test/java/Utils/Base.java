package Utils;

import Pages.InformationPage;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.YourCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();

    public final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.saucedemo.com/");

    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    public LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);

    public YourCartPage yourCartPage = PageFactory.initElements(driver, YourCartPage.class);

    public InformationPage informationPage = PageFactory.initElements(driver, InformationPage.class);


}
