package com.orangehrm.pages.pageobjects.admin;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.admin.UserManagementPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class UserManagementPO extends BasePage {
    private WebDriver driver;

    public UserManagementPO(WebDriver driver) {
        this.driver = driver;
    }

    private void selectUser(String username) {
        scrollToElement(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        waitForElementClickable(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        checkElementByJS(driver, UserManagementPUI.USER_CHECKBOX_BY_USERNAME, username);
    }

    public AddUserPO clickAddButton() {
        waitForElementClickable(driver, UserManagementPUI.ADD_BUTTON);
        clickElement(driver, UserManagementPUI.ADD_BUTTON);
        return PageGenerator.getAddUserPage(driver);
    }

    public void enterUserNameTextbox(String username) {
        waitForElementVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE);
        sleep(1);
        sendKeysElement(driver, UserManagementPUI.USERNAME_SEARCH_TEXTBOX, username);
    }

    public void clickSearchButton() {
        waitForElementClickable(driver, UserManagementPUI.SEARCH_BUTTON);
        sleep(1);
        clickElement(driver, UserManagementPUI.SEARCH_BUTTON);
    }

    public boolean isUsernameDisplayed(String username) {
        waitForElementVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        scrollToElement(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        sleep(2);
        return isElementDisplayed(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
    }

    public boolean isUserListNotEmpty() {
        waitListForElementsVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE);
        List<WebElement> userRows = getElements(driver, UserManagementPUI.USERNAMES_IN_USER_TABLE);
        return !userRows.isEmpty();
    }

    public void clickDeleteSelectedButton() {
        waitForElementClickable(driver, UserManagementPUI.DELETE_BUTTON);
        clickElement(driver, UserManagementPUI.DELETE_SELECTED_BUTTON);
    }

    public void clickConfirmButton() {
        waitForElementClickable(driver, UserManagementPUI.CONFIRM_DELETE_BUTTON);
        sleep(2);
        clickElement(driver, UserManagementPUI.CONFIRM_DELETE_BUTTON);
    }

    public boolean isUserRemoved(String username) {
        waitForElementInVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE);
        return isElementUnDisplayed(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
    }

    public void selectUsersByUsernames(String username1, String username2) {
        selectUser(username1);
        selectUser(username2);
    }

    public boolean areUsersRemoved(Map<String, String> usernameData) {
        String username1 = usernameData.get("Username1");
        String username2 = usernameData.get("Username2");
        boolean isUserRemoved1 = isUserRemoved(username1);
        boolean isUserRemoved2 = isUserRemoved(username2);
        return isUserRemoved1 && isUserRemoved2;
    }

    public void clickCancelButton() {
        waitForElementClickable(driver, UserManagementPUI.CONFIRM_CANCEL_BUTTON);
        sleep(2);
        clickElement(driver, UserManagementPUI.CONFIRM_CANCEL_BUTTON);
    }

    public boolean isUserDisplayed(String username) {
        waitForElementVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        scrollToElement(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        return isElementDisplayed(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
    }

    public void clickDeleteButton() {
        scrollToElement(driver, UserManagementPUI.DELETE_BUTTON);
        waitForElementClickable(driver, UserManagementPUI.DELETE_BUTTON);
        clickElement(driver, UserManagementPUI.DELETE_BUTTON);
    }
}
