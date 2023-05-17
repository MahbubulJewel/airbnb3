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

public class ValidateDuplicateEmail {

    private static final By ClickRegister = By.xpath("/html/body/header/div[1]/ul[1]/li[1]/span/span/a");
    private static final By EnterFirstName = By.id("firstname");
    private static final By EnterLastName = By.id("lastname");
    private static final By EnterEmail = By.id("Email");
    private static final By EnterPassword = By.id("password");
    private static final By ErrorEmail = By.id("Email_err");
    private static Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver;

    @Given("^user on the home page$")
    public void navigateToLoginPage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("User is in the login page");

    }

    @When("^user enters first name$")
    public void enterFirstName(){
        ActOn.element(driver, ClickRegister).click();
        ActOn.element(driver, EnterFirstName).setValue("Mahbubul");
        LOGGER.info("user has entered first name");
    }

    @And("^user enters last name$")
    public void enterLastName(){
        ActOn.element(driver, EnterLastName).setValue("Jewel");
        LOGGER.info("user clicks on the continue button");
    }

    @And("^enter used email address$")
    public void enterValidEmail(){
        ActOn.element(driver, EnterEmail).setValue("ummemoon1109@gmail.com");
        LOGGER.info("user has entered valid email address");
    }

    @Then("^user will get error message$")
    public void createNewAccount(){

        ActOn.element(driver, EnterPassword).click();
        AssertThat.elementAssertions(driver, ErrorEmail).elementIsDisplayed();
        LOGGER.info("user is able to create new account");

        ActOn.browser(driver).closeBrowser();
    }
}
