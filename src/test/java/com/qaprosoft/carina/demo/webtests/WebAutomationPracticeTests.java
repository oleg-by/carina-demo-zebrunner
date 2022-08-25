package com.qaprosoft.carina.demo.webtests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.enums.Categories;
import com.qaprosoft.carina.demo.enums.InfoLink;
import com.qaprosoft.carina.demo.model.Product;
import com.qaprosoft.carina.demo.webautomationpractice.components.FooterMenu;
import com.qaprosoft.carina.demo.webautomationpractice.components.HeaderMenu;
import com.qaprosoft.carina.demo.webautomationpractice.pages.*;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WebAutomationPracticeTests extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(testName = "Verify home page")
    @MethodOwner(owner = "oleg-by")
    public void testHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        FooterMenu footer = homePage.getFooter();
        Assert.assertTrue(footer.isUIObjectPresent(5), "Footer menu wasn't found!");
        Assert.assertTrue(footer.isOpened(), "Copyright is not presented on home page.");
        footer.clickCategoriesLink(Categories.WOMEN);
        CategoryPage categoryPage = new CategoryPage(getDriver());
        Assert.assertTrue(categoryPage.isOpened(), "Category page is not opened.");
        Assert.assertTrue(categoryPage.isCategoryCorrect(Categories.WOMEN.getCategory()),
                "Category is not correct.");
    }

    @Test(testName = "Check the search engine")
    @MethodOwner(owner = "oleg-by")
    public void testSearchEngine() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        String searchRq = "Printed";
        HeaderMenu header = homePage.getHeader();
        header.typeSearchRq(searchRq);
        ResultPage resultPage = header.clickSearchBtn();
        Assert.assertTrue(resultPage.isOpened(), "Result page is not opened.");
        for (String title : resultPage.getResultProductTitles()) {
            Assert.assertTrue(StringUtils
                            .containsIgnoreCase(title, searchRq),
                    "The title of product doesn't contain the search substring.");
        }
    }

    @Test(testName = "Register a new account")
    @MethodOwner(owner = "oleg-by")
    public void testSignUp() {
        MyAccountPage myAccountPage = authenticationService.register();
        Assert.assertTrue(myAccountPage.isOpened(), "Account is not created.");
        HeaderMenu header = myAccountPage.getHeader();
        String username = authenticationService.getRandomUser().getFirstname() + " "
                + authenticationService.getRandomUser().getLastname();
        Assert.assertEquals(header.getDisplayedUsername(), username,
                "The username displayed on the page does not match the registered user.");
    }

    @Test(testName = "Sign in")
    @MethodOwner(owner = "oleg-by")
    public void testSignIn() {
        MyAccountPage myAccountPage = authenticationService.login();
        Assert.assertTrue(myAccountPage.isOpened(), "Sign In is failed.");
    }

    @Test(testName = "Sign out")
    @MethodOwner(owner = "oleg-by")
    public void testSignOut() {
        MyAccountPage myAccountPage = authenticationService.login();
        Assert.assertTrue(myAccountPage.isOpened(), "Sign In is failed.");
        HeaderMenu header = myAccountPage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(5), "Header wasn't found!");
        AuthenticationPage authenticationPage = header.clickSignOutBtn();
        Assert.assertTrue(authenticationPage.isOpened(), "Authentication page is not opened");
        Assert.assertFalse(header.isUsernameDisplayed(), "The user has not logged out.");
    }

    @Test(testName = "Contact us")
    @MethodOwner(owner = "oleg-by")
    public void testContactUs() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        FooterMenu footer = homePage.getFooter();
        Assert.assertTrue(footer.isUIObjectPresent(5), "Footer menu wasn't found!");
        footer.clickInformationLink(InfoLink.CONTACT_US);
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        Assert.assertTrue(contactUsPage.isOpened(), "Contact Us page is not opened.");
        contactUsPage.selectSubjectHeading(RandomUtils.nextInt(1, 2));
        contactUsPage.typeEmail(authenticationService.getRandomUser().getEmail());
        contactUsPage.typeOrderRef(RandomUtils.nextInt());
        contactUsPage.enterMessage("Achtung!");
        contactUsPage.clickSendBtn();
        Assert.assertEquals(contactUsPage.getTextAlert(),
                "Your message has been successfully sent to our team.",
                "The message has not been successfully sent.");
    }

    @Test(testName = "Contact us with attaching file")
    @MethodOwner(owner = "oleg-by")
    public void testContactUsWithAttaching() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        HeaderMenu header = homePage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(5), "Header wasn't found!");
        ContactUsPage contactUsPage = header.clickContactBtn();
        Assert.assertTrue(contactUsPage.isOpened(), "Contact Us page is not opened.");
        contactUsPage.selectSubjectHeading(RandomUtils.nextInt(1, 2));
        contactUsPage.typeEmail(authenticationService.getRandomUser().getEmail());
        contactUsPage.typeOrderRef(RandomUtils.nextInt());
        contactUsPage.attachFile(System.getProperty("user.dir") +
                "/src/main/resources/images/empty_drawing_field.png");
        contactUsPage.enterMessage("Achtung!");
        contactUsPage.clickSendBtn();
        Assert.assertEquals(contactUsPage.getTextAlert(),
                "Your message has been successfully sent to our team.",
                "The message has not been successfully sent.");
    }

    @Test(testName = "Subscribing to newsletter")
    @MethodOwner(owner = "oleg-by")
    public void testNewsletterSubscribing() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        FooterMenu footer = homePage.getFooter();
        Assert.assertTrue(footer.isUIObjectPresent(5), "Footer menu wasn't found!");
        String testEmail = authenticationService.getRandomUser().getEmail();
        footer.typeEmail(testEmail);
        footer.clickSubmitBtn();
        Assert.assertEquals(homePage.getTextAlert("success"),
                "Newsletter : You have successfully subscribed to this newsletter.",
                "You have not successfully subscribed to this newsletter.");
        Assert.assertEquals(footer.getTextFromNewsletterField(),
                "You have successfully subscribed to this newsletter.",
                "You have not successfully subscribed to this newsletter.");
        footer.typeEmail(testEmail);
        footer.clickSubmitBtn();
        Assert.assertEquals(homePage.getTextAlert("danger"),
                "Newsletter : This email address is already registered.",
                "You can use the same emails to subscribe to this newsletter.");
        Assert.assertEquals(footer.getTextFromNewsletterField(),
                "This email address is already registered.",
                "You can use the same emails to subscribe to this newsletter.");
    }

    @Test(testName = "Adding product to cart")
    @MethodOwner(owner = "oleg-by")
    public void testAddingProductToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        FooterMenu footer = homePage.getFooter();
        Assert.assertTrue(footer.isUIObjectPresent(5), "Footer menu wasn't found!");
        footer.clickCategoriesLink(Categories.WOMEN);
        CategoryPage categoryPage = new CategoryPage(getDriver());
        Assert.assertTrue(categoryPage.isOpened(), "Category page is not opened.");
        int n = RandomUtils.nextInt(0, categoryPage.getProducts().size() - 1);
        String randomProductName = categoryPage.getProducts().get(n).getProductName();
        String randomProductPrice = categoryPage.getProducts().get(n).getProductPrice();
        ProductAddedPopUpPage popUpPage = categoryPage.getProducts().get(n).clickAddToCartBtn();
        Assert.assertTrue(popUpPage.isOpened(), "Pop Up page is not opened.");
        Assert.assertEquals(popUpPage.getSuccessTitle(), "Product successfully added to your shopping cart",
                "The information about added product is displayed incorrectly.");
        Assert.assertEquals(popUpPage.getProductTitle(), randomProductName,
                "The information about added product is displayed incorrectly.");
        Assert.assertEquals(popUpPage.getProductPrice(), randomProductPrice,
                "The information about added product is displayed incorrectly.");
        Assert.assertEquals(popUpPage.getNumberOfItems(), 1,
                "The information about added product is displayed incorrectly.");
    }

    @Test(testName = "Adding products to cart (several products)")
    @MethodOwner(owner = "oleg-by")
    public void testAddingProductsToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isOpened(), "Home page is not opened.");
        FooterMenu footer = homePage.getFooter();
        Assert.assertTrue(footer.isUIObjectPresent(5), "Footer menu wasn't found!");
        footer.clickCategoriesLink(Categories.WOMEN);
        CategoryPage categoryPage = new CategoryPage(getDriver());
        Assert.assertTrue(categoryPage.isOpened(), "Category page is not opened.");
        int maxIndex = categoryPage.getProducts().size();
        int randomNumberOfProducts = RandomUtils.nextInt(2, maxIndex - 1);
        Set<Integer> indexesSet = new TreeSet<>();
        int i = 0;
        while (i < randomNumberOfProducts) {
            int randomIndex = RandomUtils.nextInt(0, maxIndex);
            if (indexesSet.add(randomIndex)) {
                i++;
            }
        }
        List<Integer> indexes = new ArrayList<>(indexesSet);
        LOGGER.info("List of random indexes: " + indexes + ". Number of random products: " + randomNumberOfProducts);
        List<Product> products = new ArrayList<>();
        CartPage cartPage = null;
        int n = 1;
        for (Integer index : indexes) {
            String someProductName = categoryPage.getProducts().get(index).getProductName();
            String someProductPrice = categoryPage.getProducts().get(index).getProductPrice();
            LOGGER.info("The selected product N " + n + ": " + someProductName + " - " + someProductPrice + ".");
            ProductAddedPopUpPage popUpPage = categoryPage.getProducts().get(index).clickAddToCartBtn();
            Assert.assertTrue(popUpPage.isOpened(), "Pop Up page is not opened.");
            products.add(new Product(someProductName, someProductPrice));
            if (n < randomNumberOfProducts) {
                popUpPage.clickContinueBtn();
                n++;
            } else {
                cartPage = popUpPage.clickProceedBtn();
            }
        }
        Assert.assertTrue(cartPage.isOpened(), "Cart page is not opened.");
        Assert.assertEquals(cartPage.getSummaryProductsQuantity(),
                randomNumberOfProducts, "The quantity of added products is wrong.");
        double sum = 0;
        String totalPrice = String.format("%.2f", cartPage.getTotalProductsPrice());
        int j = 0;
        for(Product product : products){
            Assert.assertEquals(cartPage.getProducts().get(j).getProductName(),
                    product.getName(), "The name of added product is wrong.");
            String subPrice = StringUtils.substringBefore(cartPage.getProducts().get(j).getProductPrice()," ");
            Assert.assertEquals(subPrice, product.getPrice(), "The price of added product is wrong.");
            sum += Double.parseDouble(StringUtils.substring(product.getPrice(), 1));
            j++;
        }
        String resultSum = String.format("%.2f", sum);
        Assert.assertEquals(totalPrice, resultSum, "The total product price is wrong.");
    }
}
