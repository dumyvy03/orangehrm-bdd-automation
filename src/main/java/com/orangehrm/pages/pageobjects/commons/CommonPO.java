package com.orangehrm.pages.pageobjects.commons;

import com.orangehrm.commons.BasePage;
import com.orangehrm.pages.pageuis.commons.CommonPUI;
import org.openqa.selenium.WebDriver;

public class CommonPO extends BasePage {
    private WebDriver driver;

    public CommonPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage() {
        return getTextElement(driver, CommonPUI.ERROR_TEXT);
    }

}
