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

public class CategoryPage extends AutomationPracticePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[@class=\"category-name\"]")
    private ExtendedWebElement categoryNameTitle;

    @FindBy(xpath = "//*[@class=\"product-container\"]")
    private List<ProductContainer> products;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return categoryNameTitle.isElementPresent();
    }

    public boolean isCategoryCorrect(String title) {
        return categoryNameTitle.getText().equals(title);
    }

    public List<ProductContainer> getProducts() {
        return products;
    }

    public List<String> getResultProductTitles() {
        List<String> productTitles = new ArrayList<>();
        for (ProductContainer productContainer : products) {
            productTitles.add(productContainer.getProductName());
        }
        LOGGER.info("The list of product displayed: " + productTitles + ".");
        return productTitles;
    }
}
