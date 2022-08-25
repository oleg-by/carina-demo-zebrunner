package com.qaprosoft.carina.demo.mydemoapp.common;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class DrawingPageBase extends AbstractPage implements IMobileUtils {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDrawingPanelPresent();

}
