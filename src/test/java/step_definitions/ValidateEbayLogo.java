package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReadConfigFiles;

public class ValidateEbayLogo {
    private static final By EbayLogo = By.id("gh-l-h1");
    private static Logger LOGGER = LogManager.getLogger(ValidateEbayLogo.class);
    WebDriver driver;

    @Given("^user open the website$")
    public void OpenWebsite(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("User can open the browser");

    }

    @When("^user is on the ebay home page")
    public void navigateToHomePage(){
        LOGGER.info("user is on the home page");
    }

    @Then("^user can see the ebay logo$")
    public void validateEbayLogo(){
        AssertThat.elementAssertions(driver, EbayLogo).elementIsDisplayed();
        LOGGER.info("user can see the ebay logo");

        ActOn.browser(driver).closeBrowser();
    }
}
