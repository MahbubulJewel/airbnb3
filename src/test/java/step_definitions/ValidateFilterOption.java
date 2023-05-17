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

public class ValidateFilterOption {
    private static final By SearchItem = By.xpath("/html/body/header/table/tbody/tr/td[5]/form/table/tbody/tr/td[1]/div[1]/div/input[1]");
    private static final By ClickSearchOption = By.id("gh-btn");
    private static final By ClickNewFilter = By.xpath("/html/body/div[5]/div[3]/ul/li[1]/ul/li[3]/div[2]/ul/li[1]/div/a/div/div/div/span[2]");
    private static final By NewFilterAppear = By.xpath("/html/body/div[5]/div[4]/div[2]/div[1]/div[2]/ul/li[1]/div/div/div/div/div/ul/li[1]/div/a/div");
    private static Logger LOGGER = LogManager.getLogger(ValidateFilterOption.class);
    WebDriver driver;

    @Given("^user is on ebay website$")
    public void OpenWebsite(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("User can open the browser");

    }

    @When("^user search for iphone$")
    public void searchIphone(){
        ActOn.element(driver, SearchItem).setValue("iphone");
        ActOn.element(driver, ClickSearchOption).click();
        LOGGER.info("user able to search the iphone");
    }

    @And("^click new filter option$")
    public void clickNew(){
        ActOn.element(driver, ClickNewFilter).click();
        LOGGER.info("user able to click the new button");
    }

    @Then("^only new iphone will show$")
    public void validateFilterOption(){
        AssertThat.elementAssertions(driver, NewFilterAppear).elementIsDisplayed();
        LOGGER.info("user can see the search item");

        ActOn.browser(driver).closeBrowser();
    }
}
