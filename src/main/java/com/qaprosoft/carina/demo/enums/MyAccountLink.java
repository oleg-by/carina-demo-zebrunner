package com.qaprosoft.carina.demo.enums;

import com.qaprosoft.carina.demo.webautomationpractice.AutomationPracticePageBase;
import com.qaprosoft.carina.demo.webautomationpractice.pages.MyAccountSectionPage;

public enum MyAccountLink {

    ORDERS("My orders", MyAccountSectionPage.class),
    CREDIT("My credit slips", MyAccountSectionPage.class),
    ADDRESSES("My addresses", MyAccountSectionPage.class),
    PERSONAL("personal info", MyAccountSectionPage.class),
    SIGN_OUT("Sign out", MyAccountSectionPage.class);

    private final String accountLink;

    private final Class<? extends AutomationPracticePageBase> pageClass;

    MyAccountLink(String accountLink, Class<? extends AutomationPracticePageBase> pageClass) {
        this.accountLink = accountLink;
        this.pageClass = pageClass;
    }

    public String getAccountLink() {
        return accountLink;
    }

    public Class<? extends AutomationPracticePageBase> getPageClass() {
        return pageClass;
    }
}
