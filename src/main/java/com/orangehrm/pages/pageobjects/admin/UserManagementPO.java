package com.orangehrm.pages.pageobjects.admin;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.admin.UserManagementPUI;
import org.openqa.selenium.WebDriver;

public class UserManagementPO extends BasePage {
    private WebDriver driver;

    public UserManagementPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddUserPO clickAddButton() {
        sleep(1);
        clickElement(driver, UserManagementPUI.ADD_BUTTON);
        return PageGenerator.getAddUserPage(driver);
    }

    public boolean isUserNameDisplayed(String userName) {
        scrollToElement(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, userName);
        sleep(1);
        return isElementDisplayed(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, userName);
    }
}
