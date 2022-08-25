package com.qaprosoft.carina.demo.enums;

import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import com.qaprosoft.carina.demo.webautomationpractice.pages.ContactUsPage;
import com.qaprosoft.carina.demo.webautomationpractice.pages.InformationPageBase;

public enum InfoLink {

    SPECIALS("Specials", InformationPageBase.class),
    NEW_PRODUCTS("New products", InformationPageBase.class),
    BEST_SELLERS("Best sellers", InformationPageBase.class),
    OUR_STORES("Our stores", InformationPageBase.class),
    CONTACT_US("Contact us", ContactUsPage.class),
    TERMS("Terms and conditions of use", InformationPageBase.class),
    ABOUT_US("About us", InformationPageBase.class),
    SITEMAP("Sitemap", InformationPageBase.class);

    private final String infolink;
    private final Class<? extends AutomationPracticePageBase> pageClass;

    InfoLink(String infolink, Class<? extends AutomationPracticePageBase> pageClass) {
        this.infolink = infolink;
        this.pageClass = pageClass;
    }

    public String getInfolink() {
        return infolink;
    }

    public Class<? extends AutomationPracticePageBase> getPageClass() {
        return pageClass;
    }
}
