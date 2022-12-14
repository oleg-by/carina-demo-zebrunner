package com.qaprosoft.carina.demo.mydemoapp.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mydemoapp.common.HomePageBase;
import com.qaprosoft.carina.demo.mydemoapp.common.LogInPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LogInPageBase.class)
public class LoginPage extends LogInPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Login\"`][1]")
    private ExtendedWebElement loginTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`value == \"bob@example.com\"`]")
    private ExtendedWebElement textFieldUsername;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeSecureTextField[`value == \"••••••••\"`]")
    private ExtendedWebElement textFieldPassword;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"bob@example.com\"`]")
    private ExtendedWebElement testUsername;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Login\"`]")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void selectProvidedUsername() {
        testUsername.click();
    }

    @Override
    public HomePageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public boolean isLoginTitlePresent() {
        return loginTitle.isElementPresent();
    }

    @Override
    public boolean areFieldsFilled() {
        return textFieldUsername.isElementPresent() && textFieldPassword.isElementPresent();
    }
}
