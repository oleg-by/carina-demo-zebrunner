package com.qaprosoft.carina.demo.webtests;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.enums.Categories;
import com.qaprosoft.carina.demo.webautomationpractice.components.FooterMenu;
import com.qaprosoft.carina.demo.webautomationpractice.pages.CategoryPage;
import com.qaprosoft.carina.demo.webautomationpractice.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test(testName = "Verify home page")
    @MethodOwner(owner = "oleg-by")
    public void helloTest() {
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

}
