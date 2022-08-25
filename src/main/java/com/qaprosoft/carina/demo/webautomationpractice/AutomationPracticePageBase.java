package com.qaprosoft.carina.demo.webautomationpractice;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.webautomationpractice.components.FooterMenu;
import com.qaprosoft.carina.demo.webautomationpractice.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AutomationPracticePageBase extends AbstractPage {

    @FindBy(xpath = "//header[@id=\"header\"]")
    private HeaderMenu header;

    @FindBy(xpath = "//*[@id=\"footer\"]")
    private FooterMenu footer;

    public AutomationPracticePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public HeaderMenu getHeader(){
        return header;
    }

    public FooterMenu getFooter(){
        return footer;
    }
}
