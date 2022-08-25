package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductAddedPopUpPage extends AbstractUIObject {

    @FindBy(xpath = "//div[contains(@class,\"layer_cart_product\")]//h2")
    private ExtendedWebElement successTitle;

    @FindBy(xpath = "//div[contains(@class,\"layer_cart_cart\")]//h2")
    private ExtendedWebElement numberOfItems;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_title\"]")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_price\"]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//a[@class=\"btn btn-default button button-medium\"]")
    private ExtendedWebElement proceedBtn;

    @FindBy(xpath = "//*[@class=\"continue btn btn-default button exclusive-medium\"]")
    private ExtendedWebElement continueBtn;

    public ProductAddedPopUpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return successTitle.isElementPresent();
    }

    public String getSuccessTitle(){
        return successTitle.getText();
    }

    public int getNumberOfItems(){
        return Integer.parseInt(numberOfItems.getText().replaceAll("\\D", ""));
    }

    public String getProductTitle(){
        return productTitle.getText();
    }

    public String getProductPrice(){
        return productPrice.getText();
    }

    public CartPage clickProceedBtn(){
        proceedBtn.click();
        return new CartPage(getDriver());
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }

}
