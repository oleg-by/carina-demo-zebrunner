package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AutomationPracticePageBase {

    @FindBy(xpath = "//p[@class=\"alert alert-%s\"]")
    private ExtendedWebElement alert;

    @FindBy(xpath = "//div[@id=\"slider_row\"]")
    private ExtendedWebElement slider;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return slider.isElementPresent();
    }

    public String getTextAlert(String message) {
        return alert.format(message).getText();
    }

}
