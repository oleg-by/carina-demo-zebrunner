package com.qaprosoft.carina.demo.webautomationpractice.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartContainer extends AbstractUIObject {

    @FindBy(xpath = ".//td[@class=\"cart_description\"]//p")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//td[@class=\"cart_unit\"]//span[contains(@id,\"product_price\")]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//a[@title=\"Delete\"]")
    private ExtendedWebElement deleteBtn;

    @FindBy(xpath = ".//input[contains(@class,\"cart_quantity_input\")]")
    private ExtendedWebElement quantity;

    public CartContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getQuantity() {
        return quantity.getText();
    }

    public void clickDeleteBtn(){
        deleteBtn.click();
    }

    @Override
    public String toString() {
        return "CartContainer{" +
                "productName=" + productName.getText() +
                ", productPrice=" + productPrice.getText() +
                ", quantity=" + quantity.getText() +
                '}';
    }
}
