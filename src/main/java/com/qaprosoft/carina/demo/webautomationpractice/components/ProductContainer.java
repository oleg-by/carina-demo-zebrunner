package com.qaprosoft.carina.demo.webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.webautomationpractice.pages.ProductAddedPopUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductContainer extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class=\"product-name\"]")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//div[@class=\"right-block\"]//*[@class=\"price product-price\"]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//a[@title=\"Add to cart\"]")
    private ExtendedWebElement addToCartBtn;

    public ProductContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public ProductAddedPopUpPage clickAddToCartBtn(){
        addToCartBtn.clickByJs();
        return new ProductAddedPopUpPage(getDriver());
    }

    @Override
    public String toString() {
        return "ProductContainer{" +
                "productName=" + productName.getText() +
                '}';
    }
}
