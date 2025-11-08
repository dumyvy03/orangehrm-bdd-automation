package com.orangehrm.pages.pageobjects.admin;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.admin.AddUserPUI;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddUserPO extends BasePage {
    private WebDriver driver;

    public AddUserPO(WebDriver driver) {
        this.driver = driver;
    }

    public void selectUserRoleDropdown(String userRole) {
        sleep(1);
        selectDropdownCustomer(driver, AddUserPUI.USER_ROLE_DROPDOWN_PARENT, AddUserPUI.USER_ROLE_DROPDOWN_CHILD, userRole);
    }

    public void enterAndSelectEmployeeName(String employeeName) {
        sleep(1);
        sendKeysElement(driver, AddUserPUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
        selectDropdownSuggestion(driver, AddUserPUI.EMPLOYEE_NAME_SUGGESTION_DROPDOWN, employeeName);
    }

    public void selectStatusDropdown(String status) {
        sleep(1);
        selectDropdownCustomer(driver, AddUserPUI.STATUS_DROPDOWN_PARENT, AddUserPUI.STATUS_DROPDOWN_CHILD, status);
    }

    public void enterUserNameTextbox(String username) {
        sleep(1);
        sendKeysElement(driver, AddUserPUI.USERNAME_TEXTBOX, username);
    }

    public void enterPasswordTextbox(String password) {
        sleep(1);
        sendKeysElement(driver, AddUserPUI.PASSWORD_TEXTBOX, password);
    }

    public void enterConfirmPasswordTextbox(String confirmPassword) {
        sleep(1);
        sendKeysElement(driver, AddUserPUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void enterUserInformation(Map<String, String> userInformationData) {
        selectUserRoleDropdown(userInformationData.get("User Role"));
        enterAndSelectEmployeeName(userInformationData.get("Employee Name"));
        selectStatusDropdown(userInformationData.get("Status"));
        enterUserNameTextbox(userInformationData.get("Username"));
        enterPasswordTextbox(userInformationData.get("Password"));
        enterConfirmPasswordTextbox(userInformationData.get("Confirm Password"));
    }

    public UserManagementPO clickSaveButton() {
        sleep(1);
        clickElement(driver, AddUserPUI.SAVE_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getUserManagementPage(driver);
    }

    public String getConfirmPasswordErrorMessage() {
        sleep(1);
        return getElementText(driver, AddUserPUI.CONFIRM_PASSWORD_ERROR_TEXT);
    }

    public void enterEmployeeNameTextbox(String employeeName) {
        sleep(1);
        sendKeysElement(driver, AddUserPUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
    }

    public String getSuggestionDropdownMessage() {
        sleep(2);
        return getElementText(driver, AddUserPUI.EMPLOYEE_NAME_NO_RECORDS);
    }
}
