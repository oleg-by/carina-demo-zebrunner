package com.qaprosoft.carina.demo.mydemoapp.common;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LogInPageBase extends AbstractPage implements IMobileUtils {

    public LogInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectProvidedUsername();

    public abstract HomePageBase clickLoginBtn();

    public abstract boolean isLoginTitlePresent();

    public abstract boolean areFieldsFilled();

}
