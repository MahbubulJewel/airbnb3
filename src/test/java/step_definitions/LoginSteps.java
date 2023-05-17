package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private static final By ClickSign = By.xpath("/html/body/header/div[1]/ul[1]/li[1]/span/a");
    private static final By EntersEmail = By.id("userid");
    private static final By ClickContinueButton = By.id("signin-continue-btn");
    private static final By EntersPassword = By.id("pass");
    private static final By ClickSignIn = By.id("sgnBt");
    private static final By Hi = By.id("gh-ug");
    private static Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^user is on the ebay home page1$")
    public void navigateToLoginPage(){

        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("AppURL"));

        LOGGER.info("User is in the login page");

    }

    @When("^user enters email \"(.+?)\"$")
    public void enterEmailAddress(String email){
        ActOn.element(driver, ClickSign).click();
        ActOn.element(driver, EntersEmail).setValue(email);
        LOGGER.info("user has entered email address");
    }
    @When("^user click on login upon valid credentials$")
    public void userClickOnLogin(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data){
            ActOn.element(driver, ClickSign).click();
            ActOn.element(driver, EntersEmail).setValue(cells.get("email"));
            ActOn.element(driver, ClickContinueButton).click();
            ActOn.element(driver, EntersPassword).setValue(cells.get("password"));
            ActOn.element(driver, ClickSignIn).click();
        }
    }

    @And("^user clicks continue$")
    public void clickContinueButton(){
        ActOn.element(driver, ClickContinueButton).click();
        LOGGER.info("user clicks on the continue button");
    }

    @And("^user enters password \"(.+?)\"$")
    public void enterPassword(String password){
        ActOn.element(driver, EntersPassword).setValue(password);
        LOGGER.info("user has entered password");
    }

    @And("^user clicks signIn$")
    public void clickLoginPage(){
        ActOn.element(driver, ClickSignIn).click();
        LOGGER.info("user clicks login page");
    }

    @Then("^user can starts shopping$")
    public void validateUserIsLoginSuccessfully(){
        AssertThat.elementAssertions(driver, Hi).elementIsDisplayed();
        LOGGER.info("user is on the homepage");

    }
}
