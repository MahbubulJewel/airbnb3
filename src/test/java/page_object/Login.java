package page_object;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;
import step_definitions.LoginSteps;

public class Login {
    private static final By ClickSign = By.xpath("/html/body/header/div[1]/ul[1]/li[1]/span/a");
    private static final By EntersEmail = By.id("userid");
    private static final By ClickContinueButton = By.id("signin-continue-btn");
    private static final By EntersPassword = By.id("pass");
    private static final By ClickSignIn = By.id("sgnBt");
    private static final By Hi = By.id("gh-ug");
    private static Logger LOGGER = LogManager.getLogger(Login.class);
    WebDriver driver = Hooks.driver;


    public Login clickTheSignButton() {
        LOGGER.debug("Clicking on the sign");
        ActOn.element(driver, ClickSign).click();
        return this;
    }

    public Login typeEmailAddress(String value) {
        LOGGER.debug("Typing Email: " + value);
        ActOn.element(driver, EntersEmail).setValue(value);
        return this;

    }
}