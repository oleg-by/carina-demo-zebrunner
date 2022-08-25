package com.qaprosoft.carina.demo.webautomationpractice.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.model.User;
import com.qaprosoft.carina.demo.utils.DataLoader;
import com.qaprosoft.carina.demo.webautomationpractice.components.HeaderMenu;
import com.qaprosoft.carina.demo.webautomationpractice.pages.AuthenticationPage;
import com.qaprosoft.carina.demo.webautomationpractice.pages.CreateAccountPage;
import com.qaprosoft.carina.demo.webautomationpractice.pages.HomePage;
import com.qaprosoft.carina.demo.webautomationpractice.pages.MyAccountPage;
import org.testng.Assert;

public class AuthenticationService implements IDriverPool {

    private final static String USERNAME = R.TESTDATA.get("username");

    private final static String PASSWORD = R.TESTDATA.get("password");

    private User randomUser = DataLoader.getRandomUser();

    public User getRandomUser() {
        return randomUser;
    }

    public MyAccountPage register() {
        return register(randomUser);
    }

    public MyAccountPage register(User user) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        HeaderMenu header = homePage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(5), "Header wasn't found!");
        AuthenticationPage authenticationPage = header.clickSignInBtn();
        Assert.assertTrue(authenticationPage.isOpened(), "Authentication page is not opened");
        authenticationPage.typeNewEmail(user.getEmail());
        CreateAccountPage createAccountPage = authenticationPage.clickCreateBtn();
        Assert.assertTrue(createAccountPage.isOpened(), "Create account page is not opened");
        createAccountPage.clickGender(user.getGender());
        createAccountPage.typeFirstName(user.getFirstname());
        createAccountPage.typeLastName(user.getLastname());
        createAccountPage.typePassword(user.getPassword());
        createAccountPage.typeAddress(user.getAddress());
        createAccountPage.typeCity(user.getCity());
        createAccountPage.selectState(user.getState());
        createAccountPage.typePostcode(user.getPostcode());
        createAccountPage.typeMobilePhone(user.getMobilePhone());
        return createAccountPage.clickRegisterBtn();
    }

    public MyAccountPage login() {
        return login(USERNAME, PASSWORD);
    }

    public MyAccountPage login(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        HeaderMenu header = homePage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(5), "Header wasn't found!");
        AuthenticationPage authenticationPage = header.clickSignInBtn();
        Assert.assertTrue(authenticationPage.isOpened(), "Authentication page is not opened");
        authenticationPage.typeEmail(username);
        authenticationPage.typePassword(password);
        return authenticationPage.clickSignInBtn();
    }

}
