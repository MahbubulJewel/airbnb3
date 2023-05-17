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


public class EstimatePrice {

    private static final By SearchOption = By.xpath("/html/body/header/table/tbody/tr/td[5]/form/table/tbody/tr/td[3]/input");
    private static Logger LOGGER = LogManager.getLogger(EstimatePrice.class);
    WebDriver driver;

    @Given("^user open the browser$")
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("user can open the browser");

    }

    @When("^user is on the home page")
    public void NavigateToHomepage(){
        LOGGER.info("user is on the home page");
    }

    @Then("^user can see the search option$")
    public void validateSearchOption(){
        AssertThat.elementAssertions(driver, SearchOption).elementIsDisplayed();
        LOGGER.info("user can see the search option");

        ActOn.browser(driver).closeBrowser();
    }
}
