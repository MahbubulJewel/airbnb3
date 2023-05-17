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

public class ShopByCategory {

    private static final By ClickShopByCategory = By.id("gh-shop-a");
    private static final By MotorButton = By.xpath("/html/body/header/table/tbody/tr/td[4]/div/div/table/tbody/tr/td[1]/h3[1]/a");
    private static final By ElectronicButton = By.xpath("/html/body/header/table/tbody/tr/td[4]/div/div/table/tbody/tr/td[2]/h3[1]/a");
    private static final By CollectiblesAndArtButton = By.xpath("/html/body/header/table/tbody/tr/td[4]/div/div/table/tbody/tr/td[3]/h3[1]/a");
    private static final By ClothingButton = By.xpath("/html/body/header/table/tbody/tr/td[4]/div/div/table/tbody/tr/td[1]/h3[2]/a");
    private static Logger LOGGER = LogManager.getLogger(ShopByCategory.class);
    WebDriver driver;

    @Given("^customer is on home page$")
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("user can open the browser");

    }

    @When("^user clicks shop by category$")
    public void ClickShopByCategory(){
        ActOn.element(driver, ClickShopByCategory).click();
        LOGGER.info("user has clicked the shop by category button");
    }

    @Then("^all option will appear$")
    public void validateAllOption(){
        AssertThat.elementAssertions(driver, MotorButton).elementIsDisplayed();
        AssertThat.elementAssertions(driver, ElectronicButton).elementIsDisplayed();
        AssertThat.elementAssertions(driver, CollectiblesAndArtButton).elementIsDisplayed();
        AssertThat.elementAssertions(driver, ClothingButton).elementIsDisplayed();
        LOGGER.info("user can see all option");

        ActOn.browser(driver).closeBrowser();
    }
}
