package com.orangehrm.pages.admin;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class UserManagementPO extends BasePage {
    private WebDriver driver;

    public UserManagementPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select user with username: {0}")
    private void selectUser(String username) {
        waitForElementPresence(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        scrollIntoViewJS(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        waitForElementClickable(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        checkElementByJS(driver, UserManagementPUI.USER_CHECKBOX_BY_USERNAME, username);
        sleep(1);
    }

    @Step("Click Add button")
    public AddUserPO clickAddButton() {
        waitForElementClickable(driver, UserManagementPUI.ADD_BUTTON);
        clickElement(driver, UserManagementPUI.ADD_BUTTON);
        return PageGenerator.getAddUserPage(driver);
    }

    @Step("Enter Username: {0}")
    public void enterUserNameTextbox(String username) {
        waitForElementVisible(driver, UserManagementPUI.USERNAME_SEARCH_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserManagementPUI.USERNAME_SEARCH_TEXTBOX, username);
    }

    @Step("Click Search button")
    public void clickSearchButton() {
        waitForElementClickable(driver, UserManagementPUI.SEARCH_BUTTON);
        sleep(1);
        clickElement(driver, UserManagementPUI.SEARCH_BUTTON);
    }

    @Step("Verify username '{0}' is displayed")
    public boolean isUsernameDisplayed(String username) {
        waitForElementVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        scrollIntoViewJS(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        return isElementDisplayed(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
    }

    @Step("Verify user list is not empty")
    public boolean isUserListNotEmpty() {
        waitListForElementsVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE);
        List<WebElement> userRows = getElements(driver, UserManagementPUI.USERNAMES_IN_USER_TABLE);
        return !userRows.isEmpty();
    }

    @Step("Click Delete Selected button")
    public void clickDeleteSelectedButton() {
        waitForElementClickable(driver, UserManagementPUI.DELETE_SELECTED_BUTTON);
        clickElement(driver, UserManagementPUI.DELETE_SELECTED_BUTTON);
    }

    @Step("Click Delete button on the confirmation dialog")
    public void clickDeleteConfirmButton() {
        waitForElementClickable(driver, UserManagementPUI.CONFIRM_DELETE_BUTTON);
        sleep(1);
        clickElement(driver, UserManagementPUI.CONFIRM_DELETE_BUTTON);
    }

    @Step("Verify user '{0}' is removed ")
    public boolean isUserRemoved(String username) {
        waitForElementInVisible(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
        return isElementUnDisplayed(driver, UserManagementPUI.USERNAME_IN_USER_TABLE, username);
    }

    @Step("Select multiple users: {0} and {1}")
    public void selectUsersByUsernames(String username1, String username2) {
        selectUser(username1);
        selectUser(username2);
    }

    @Step("Verify both users are removed")
    public boolean areUsersRemoved(Map<String, String> usernameData) {
        boolean isUserRemoved1 = isUserRemoved(usernameData.get("Username1"));
        boolean isUserRemoved2 = isUserRemoved(usernameData.get("Username2"));
        return isUserRemoved1 && isUserRemoved2;
    }

    @Step("Click Cancle button on the confirmation dialog")
    public void clickCancelConfirmButton() {
        waitForElementClickable(driver, UserManagementPUI.CONFIRM_CANCEL_BUTTON);
        sleep(1);
        clickElement(driver, UserManagementPUI.CONFIRM_CANCEL_BUTTON);
    }

    @Step("Click Delete button")
    public void clickDeleteButton() {
        waitForElementPresence(driver, UserManagementPUI.DELETE_BUTTON);
        scrollIntoViewJS(driver, UserManagementPUI.DELETE_BUTTON);
        waitForElementClickable(driver, UserManagementPUI.DELETE_BUTTON);
        sleep(1);
        clickElement(driver, UserManagementPUI.DELETE_BUTTON);
    }
    
    @Step("Get search result message")
    public String getSearchResultMessage() {
        waitForElementVisible(driver, UserManagementPUI.SEARCH_RESULT_MESSAGE);
        return getElementText(driver, UserManagementPUI.SEARCH_RESULT_MESSAGE);
    }
}
