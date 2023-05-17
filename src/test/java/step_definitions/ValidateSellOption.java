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

public class ValidateSellOption {
    private static final By ClickSellButton = By.xpath("/html/body/header/div[1]/ul[2]/li[1]/a");
    private static final By ClickMakeAList = By.xpath("/html/body/div[2]/div[2]/main/div[1]/div/section[1]/div/div/a");

    private static final By StartYourListing = By.xpath("/html/body/div[2]/div[2]/main/div/div/h1");
    private static Logger LOGGER = LogManager.getLogger(ValidateSellOption.class);
    WebDriver driver;

    @Given("^user can see the home page$")
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("user can open the browser");

    }

    @When("^user click sell option")
    public void ClickSell(){
        ActOn.element(driver, ClickSellButton).click();
        LOGGER.info("user is on the home page");
    }

    @And("^Click list an item")
    public void ClickList(){
        ActOn.element(driver, ClickMakeAList).click();
        LOGGER.info("user can click the list item");
    }

    @Then("^Start your listing will appear$")
    public void validateSellOption(){
        AssertThat.elementAssertions(driver, StartYourListing).elementIsDisplayed();
        LOGGER.info("user can see the search option");

        ActOn.browser(driver).closeBrowser();
    }

}
