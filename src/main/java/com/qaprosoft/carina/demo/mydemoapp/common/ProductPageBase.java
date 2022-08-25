package com.qaprosoft.carina.demo.mydemoapp.common;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage implements IMobileUtils {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitleOpened(String title);

    public abstract boolean isImagePresent();

    public abstract boolean isPricePresent();

    public abstract boolean isStarSelectedPresent();

    public abstract boolean isStarUnSelectedPresent();

    public abstract boolean isColorsPresent();

    public abstract boolean isMinusIconPresent();

    public abstract boolean isPlusIconPresent();

    public abstract boolean isAddToCartBtnPresent();

    public abstract boolean isHighlightsTitlePresent();

    public abstract boolean scrollPageDown();

    public abstract MainMenuBase clickMenuBtn();

    public abstract void backHome();


}
