package com.orangehrm.pages.admin;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddUserPO extends BasePage {
    private WebDriver driver;

    public AddUserPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select User Role: {0}")
    public void selectUserRoleDropdown(String userRole) {
        waitForElementClickable(driver, AddUserPUI.USER_ROLE_DROPDOWN_PARENT);
        sleep(2);
        selectDropdownCustomer(driver, AddUserPUI.USER_ROLE_DROPDOWN_PARENT, AddUserPUI.USER_ROLE_DROPDOWN_CHILD, userRole);
    }

    @Step("Enter and Select Employee Name: {0}")
    public void enterAndSelectEmployeeName(String employeeName) {
        waitForElementVisible(driver, AddUserPUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeysElement(driver, AddUserPUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
        sleep(2);
        selectDropdownSuggestion(driver, AddUserPUI.EMPLOYEE_NAME_SUGGESTION, employeeName);
    }

    @Step("Select Status: {0}")
    public void selectStatusDropdown(String status) {
        waitForElementClickable(driver, AddUserPUI.STATUS_DROPDOWN_PARENT);
        sleep(2);
        selectDropdownCustomer(driver, AddUserPUI.STATUS_DROPDOWN_PARENT, AddUserPUI.STATUS_DROPDOWN_CHILD, status);
    }

    @Step("Enter Username: {0}")
    public void enterUserNameTextbox(String username) {
        waitForElementVisible(driver, AddUserPUI.USERNAME_TEXTBOX);
        sleep(2);
        sendKeysElement(driver, AddUserPUI.USERNAME_TEXTBOX, username);
    }

    @Step("Enter Password: {0}")
    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, AddUserPUI.PASSWORD_TEXTBOX);
        sleep(2);
        sendKeysElement(driver, AddUserPUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter Confirm Password: {0}")
    public void enterConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, AddUserPUI.CONFIRM_PASSWORD_TEXTBOX);
        sleep(2);
        sendKeysElement(driver, AddUserPUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    @Step("Enter all user information")
    public void enterUserInformation(Map<String, String> userInformationData) {
        selectUserRoleDropdown(userInformationData.get("User Role"));
        enterAndSelectEmployeeName(userInformationData.get("Employee Name"));
        selectStatusDropdown(userInformationData.get("Status"));
        enterUserNameTextbox(userInformationData.get("Username"));
        enterPasswordTextbox(userInformationData.get("Password"));
        enterConfirmPasswordTextbox(userInformationData.get("Confirm Password"));
    }

    @Step("Click Save button")
    public UserManagementPO clickSaveButton() {
        waitForElementClickable(driver, AddUserPUI.SAVE_BUTTON);
        sleep(1);
        clickElement(driver, AddUserPUI.SAVE_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getUserManagementPage(driver);
    }

    @Step("Enter Employee Name: {0}")
    public void enterEmployeeNameTextbox(String employeeName) {
        waitForElementVisible(driver, AddUserPUI.EMPLOYEE_NAME_TEXTBOX);
        sleep(2);
        sendKeysElement(driver, AddUserPUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
    }

    @Step("Get suggestion message")
    public String getSuggestionDropdownMessage() {
        waitForElementVisible(driver, AddUserPUI.EMPLOYEE_NAME_SUGGESTION_NO_RECORDS);
        sleep(2);
        return getElementText(driver, AddUserPUI.EMPLOYEE_NAME_SUGGESTION_NO_RECORDS);
    }

    @Step("Get Username error message")
    public String getUsernameErrorMessage() {
        waitForElementVisible(driver, AddUserPUI.USERNAME_ERROR_MESSAGE);
        sleep(2);
        return getElementText(driver, AddUserPUI.USERNAME_ERROR_MESSAGE);
    }

    @Step("Get Password error message")
    public String getPasswordErrorMessage() {
        waitForElementVisible(driver, AddUserPUI.PASSWORD_ERROR_MESSAGE);
        sleep(2);
        return getElementText(driver, AddUserPUI.PASSWORD_ERROR_MESSAGE);
    }

    @Step("Get Confirm Password error message")
    public String getConfirmPasswordErrorMessage() {
        waitForElementVisible(driver, AddUserPUI.CONFIRM_PASSWORD_TEXTBOX);
        sleep(2);
        return getElementText(driver, AddUserPUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }
}
