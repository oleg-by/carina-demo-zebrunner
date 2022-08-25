package com.qaprosoft.carina.demo.webautomationpractice.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import com.qaprosoft.carina.demo.webautomationpractice.components.ProductContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class ResultPage extends AutomationPracticePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@class=\"heading-counter\"]")
    private ExtendedWebElement resultsCounter;

    @FindBy(xpath = "//*[@class=\"product-container\"]")
    private List<ProductContainer> resultProducts;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        LOGGER.info(getNumberOfProductFound() + " results have been found.");
        return resultsCounter.isElementPresent();
    }

    public int getNumberOfProductFound() {
        return resultProducts.size();
    }

    public List<String> getResultProductTitles() {
        List<String> productTitles = new ArrayList<>();
        for (ProductContainer productContainer : resultProducts) {
            productTitles.add(productContainer.getProductName());
        }
        LOGGER.info("The list of product found: " + productTitles + ".");
        return productTitles;
    }

    public List<ProductContainer> getResultProducts() {
        return resultProducts;
    }
}
