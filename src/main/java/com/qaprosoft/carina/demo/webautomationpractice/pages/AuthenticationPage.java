package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AuthenticationPage extends AutomationPracticePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"center_column\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//input[@id=\"email_create\"]")
    private ExtendedWebElement emailCreateField;

    @FindBy(xpath = "//input[@id=\"email\"]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id=\"passwd\"]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@id=\"SubmitCreate\"]")
    private ExtendedWebElement createAccountBtn;

    @FindBy(xpath = "//button[@id=\"SubmitLogin\"]")
    private ExtendedWebElement signInBtn;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void typeNewEmail(String email) {
        emailCreateField.type(email);
    }

    public CreateAccountPage clickCreateBtn() {
        createAccountBtn.click();
        return new CreateAccountPage(getDriver());
    }

    public void typeEmail(String email) {
        emailField.type(email);
        LOGGER.info("Email '" + email + "' was entered in text field.");
    }

    public void typePassword(String pass) {
        passwordField.type(pass);
        LOGGER.info("Password '" + pass + "' was entered in text field.");
    }

    public MyAccountPage clickSignInBtn() {
        signInBtn.click();
        return new MyAccountPage(getDriver());
    }

}
