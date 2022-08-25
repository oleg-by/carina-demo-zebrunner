package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends InformationPageBase {

    @FindBy(xpath = "//select[@id=\"id_contact\"]")
    private ExtendedWebElement subjectHeadingBox;

    @FindBy(xpath = "//input[@id=\"email\"]")
    private ExtendedWebElement email;

    @FindBy(xpath = "//input[@id=\"id_order\"]")
    private ExtendedWebElement orderRef;

    @FindBy(xpath = "//input[@id=\"fileUpload\"]")
    private ExtendedWebElement file;

    @FindBy(xpath = "//textarea[@id=\"message\"]")
    private ExtendedWebElement messageArea;

    @FindBy(xpath = "//button[@id=\"submitMessage\"]")
    private ExtendedWebElement sendBtn;

    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    private ExtendedWebElement alertSuccess;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void selectSubjectHeading(int i) {
        subjectHeadingBox.select(i);
    }

    public void typeEmail(String email) {
        this.email.type(email);
    }

    public void typeOrderRef(int num) {
        orderRef.type(String.valueOf(num));
    }

    public void attachFile(String path) {
        file.attachFile(path);
    }

    public void enterMessage(String text) {
        messageArea.type(text);
    }

    public void clickSendBtn() {
        sendBtn.click();
    }

    public String getTextAlert() {
        return alertSuccess.getText();
    }
}
