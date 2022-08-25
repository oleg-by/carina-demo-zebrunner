package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AutomationPracticePageBase {

    @FindBy(xpath = "//h1[text()=\"Create an account\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@id=\"id_gender%s\"]")
    private ExtendedWebElement gender;

    @FindBy(xpath = "//input[@id=\"customer_firstname\"]")
    private ExtendedWebElement customerFirstName;

    @FindBy(xpath = "//input[@id=\"customer_lastname\"]")
    private ExtendedWebElement customerLastName;

    @FindBy(xpath = "//input[@id=\"passwd\"]")
    private ExtendedWebElement password;

    @FindBy(xpath = "//input[@id=\"address1\"]")
    private ExtendedWebElement address;

    @FindBy(xpath = "//input[@id=\"city\"]")
    private ExtendedWebElement city;

    @FindBy(xpath = "//select[@id=\"id_state\"]")
    private ExtendedWebElement state;

    @FindBy(xpath = "//input[@id=\"postcode\"]")
    private ExtendedWebElement postcode;

    @FindBy(xpath = "//input[@id=\"phone_mobile\"]")
    private ExtendedWebElement mobilePhone;

    @FindBy(xpath = "//button[@id=\"submitAccount\"]")
    private ExtendedWebElement registerBtn;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

    public void clickGender(int g){
        gender.format(String.valueOf(g)).click();
    }

    public void typeFirstName(String text){
        customerFirstName.type(text);
    }

    public void typeLastName(String text){
        customerLastName.type(text);
    }

    public void typePassword(String text){
        password.type(text);
    }

    public void typeAddress(String text){
        address.type(text);
    }

    public void typeCity(String text){
        city.type(text);
    }

    public void selectState(int id){
        state.select(id);
    }

    public void typePostcode(String text){
        postcode.type(text);
    }

    public void typeMobilePhone(String phone){
        mobilePhone.type(phone);
    }

    public MyAccountPage clickRegisterBtn(){
        registerBtn.click();
        return new MyAccountPage(getDriver());
    }
}
