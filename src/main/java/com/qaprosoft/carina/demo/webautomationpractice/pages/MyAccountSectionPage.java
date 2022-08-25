package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class MyAccountSectionPage extends AutomationPracticePageBase {

    @FindBy(xpath = "//div[@id=\"center_column\"]/h1")
    private ExtendedWebElement title;

    public MyAccountSectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

}
