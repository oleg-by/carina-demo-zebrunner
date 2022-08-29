package com.qaprosoft.carina.demo.mobiletests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.enums.MenuItem;
import com.qaprosoft.carina.demo.mydemoapp.common.HomePageBase;
import com.qaprosoft.carina.demo.mydemoapp.common.LogInPageBase;
import com.qaprosoft.carina.demo.mydemoapp.common.MainMenuBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "Sign in automatically; Log Out", value = {"mobile", "regression"})
    public void testLoginService() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isLogoPresent(), "App Home page isn't opened.");
        MainMenuBase menu = homePage.clickMenuBtn();
        Assert.assertTrue(menu.isViewMenuPresent(MenuItem.LOGIN), "Main Menu isn't opened.");
        LogInPageBase loginPage = menu.clickLogInItem(MenuItem.LOGIN);
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
        loginPage.selectProvidedUsername();
        Assert.assertTrue(loginPage.areFieldsFilled(), "The username and password fields are not filled.");
        homePage = loginPage.clickLoginBtn();
        Assert.assertTrue(homePage.isLogoPresent(), "Catalog Page isn't opened.");
        menu = homePage.clickMenuBtn();
        Assert.assertTrue(menu.isViewMenuPresent(MenuItem.LOGIN), "Main Menu isn't opened.");
        loginPage = menu.clickLogInItem(MenuItem.LOGIN);
        Assert.assertTrue(loginPage.isLoginTitlePresent(), "Login Page isn't opened.");
    }
}
