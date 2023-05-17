package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.And;
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

public class VerifySearchIntelligence {
    private static final By SearchItem = By.xpath("/html/body/header/table/tbody/tr/td[5]/form/table/tbody/tr/td[1]/div[1]/div/input[1]");
    private static final By ClickSearchOption = By.id("gh-btn");
    private static final By SearchItemAppear = By.xpath("//*[@id=\"mainContent\"]/div[1]/div[2]/div[2]/div[1]/div[1]/h1/span[2]");
    private static Logger LOGGER = LogManager.getLogger(ValidateEbayLogo.class);
    WebDriver driver;

    @Given("^user is on ebay website home page$")
    public void OpenWebsite(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("User can open the browser");

    }

    @When("^user search for SearchItem$")
    public void navigateToHomePage(){
        ActOn.element(driver, SearchItem).setValue("iphone");
        LOGGER.info("user is on the home page");
    }

    @And("^Click the search option$")
    public void clickTheSearch(){
        ActOn.element(driver, ClickSearchOption).click();
        LOGGER.info("user is on the home page");
    }

    @Then("^user can see result for the SearchItem$")
    public void validateEbayLogo(){
        AssertThat.elementAssertions(driver, SearchItemAppear).elementIsDisplayed();
        LOGGER.info("user can see the search item");

        ActOn.browser(driver).closeBrowser();
    }
}
