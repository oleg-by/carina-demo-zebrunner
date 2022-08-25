package com.qaprosoft.carina.demo.mydemoapp.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mydemoapp.common.DrawingPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {

    @ExtendedFindBy(image = "images/empty_drawing_field.png")
    private ExtendedWebElement drawingPanel;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDrawingPanelPresent() {
        return drawingPanel.isElementPresent();
    }
}
