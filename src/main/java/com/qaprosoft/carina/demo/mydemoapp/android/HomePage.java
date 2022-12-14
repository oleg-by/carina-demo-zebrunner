package com.qaprosoft.carina.demo.mydemoapp.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mydemoapp.common.HomePageBase;
import com.qaprosoft.carina.demo.mydemoapp.common.MainMenuBase;
import com.qaprosoft.carina.demo.mydemoapp.common.ProductPageBase;
import com.qaprosoft.carina.demo.mydemoapp.common.SortByPopUpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @ExtendedFindBy(accessibilityId = "App logo and name")
    private ExtendedWebElement logo;
    @ExtendedFindBy(accessibilityId = "View menu")
    private ExtendedWebElement menuBtn;
    @ExtendedFindBy(accessibilityId = "Shows current sorting order and displays available sorting options")
    private ExtendedWebElement sortBtn;
    @ExtendedFindBy(accessibilityId = "View cart")
    private ExtendedWebElement cartBtn;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id = \"com.saucelabs.mydemoapp.android:id/productIV\" and contains(@content-desc, \"%s\")]")
    private ExtendedWebElement someProductImage;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\"])[1]")
    private ExtendedWebElement firstSortedProduct;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainMenuBase clickMenuBtn() {
        menuBtn.click();
        return initPage(getDriver(), MainMenuBase.class);
    }

    @Override
    public SortByPopUpPageBase clickSortBtn() {
        sortBtn.click();
        return initPage(getDriver(), SortByPopUpPageBase.class);
    }

    @Override
    public String getFirstSortedProduct() {
        return firstSortedProduct.getText();
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    @Override
    public ProductPageBase clickGood(String title) {
        if (swipe(someProductImage.format(title), 10)) {
            someProductImage.format(title).click();
        }
        return initPage(getDriver(), ProductPageBase.class);
    }
}
