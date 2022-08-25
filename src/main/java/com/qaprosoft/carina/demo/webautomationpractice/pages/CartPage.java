package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import com.qaprosoft.carina.demo.webautomationpractice.components.CartContainer;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class CartPage extends AutomationPracticePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//h1[@id=\"cart_title\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[@id=\"summary_products_quantity\"]")
    private ExtendedWebElement summaryProductsQuantity;

    @FindBy(xpath = "//tr[contains(@id,\"product\")]")
    private List<CartContainer> products;

    @FindBy(xpath = "//td[@id=\"total_product\"]")
    private ExtendedWebElement totalProductsPrice;

    @FindBy(xpath = "//p[@class=\"alert alert-warning\"]")
    private ExtendedWebElement alertWarn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

    public int getSummaryProductsQuantity(){
        return Integer.parseInt(summaryProductsQuantity.getText().replaceAll("\\D", ""));
    }

    public Double getTotalProductsPrice(){
        return Double.parseDouble(StringUtils.substring(totalProductsPrice.getText(), 1));
    }

    public String getTextAlert(){
        return alertWarn.getText();
    }

    public List<CartContainer> getProducts(){
        return products;
    }

}
