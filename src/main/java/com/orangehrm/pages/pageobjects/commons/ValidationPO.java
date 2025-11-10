package com.orangehrm.pages.pageobjects.commons;

import com.orangehrm.commons.BasePage;
import com.orangehrm.pages.pageuis.commons.ValidationPUI;
import org.openqa.selenium.WebDriver;

public class ValidationPO extends BasePage {
    private WebDriver driver;

    public ValidationPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameErrorMessage() {
        return getElementText(driver, ValidationPUI.FIRSTNAME_ERROR_TEXT);
    }

    public String getUsernameErrorMessage() {
        sleep(2);
        return getElementText(driver, ValidationPUI.USERNAME_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        return getElementText(driver, ValidationPUI.PASSWORD_ERROR_MESSAGE);
    }

}
