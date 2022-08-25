package com.qaprosoft.carina.demo.mydemoapp.common;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.enums.MenuItem;
import org.openqa.selenium.WebDriver;

public abstract class MainMenuBase extends AbstractPage implements IMobileUtils {
    public MainMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isViewMenuPresent(MenuItem item);

    public abstract HomePageBase clickCatalogItem(MenuItem item);

    public abstract DrawingPageBase clickDrawingItem(MenuItem item);

    public abstract LogInPageBase clickLogInItem(MenuItem item);

    public abstract HomePageBase closeMenu();
}
