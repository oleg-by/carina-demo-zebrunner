package com.qaprosoft.carina.demo.enums;

import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import com.qaprosoft.carina.demo.webautomationpractice.pages.CategoryPage;

public enum Categories {

    WOMEN("Women", CategoryPage.class),
    TOPS("Tops", CategoryPage.class),
    BLOUSES("Blouses", CategoryPage.class),
    TSHIRTS("T-shirts", CategoryPage.class),
    DRESSES("Dresses", CategoryPage.class);

    private final String category;
    private final Class<? extends AutomationPracticePageBase> pageClass;

    Categories(String category, Class<? extends AutomationPracticePageBase> pageClass) {
        this.category = category;
        this.pageClass = pageClass;
    }
    public String getCategory() {
        return category;
    }
    public Class<? extends AutomationPracticePageBase> getPageClass() {
        return pageClass;
    }
}
