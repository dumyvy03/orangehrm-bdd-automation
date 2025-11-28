package com.orangehrm.pages.pim;

import com.orangehrm.core.BasePage;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.ui.pim.EmployeeListPUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Add Employee page")
    public AddEmployeePO openAddEmployeePage() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_LINK);
        clickElement(driver, EmployeeListPUI.ADD_EMPLOYEE_LINK);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getAddEmployeePage(driver);
    }

    @Step("Click Delete button")
    public void clickDeleteEmployeeButton(String employeeID) {
        waitForElementVisible(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
        scrollIntoViewJS(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
        waitForElementClickable(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
        sleep(2);
        clickElement(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
    }

    @Step("Click Delete button on the confirmation dialog")
    public void clickConfirmDeleteButton() {
        waitForElementClickable(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
        sleep(2);
        clickElement(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
    }

    @Step("Verify employee with ID '{0}' is deleted")
    public boolean isEmployeeDeleted(String employeeID) {
        waitForLoadingIconInvisible(driver);
        return isElementUnDisplayed(driver, EmployeeListPUI.EMPLOYEE_ID_IN_EMPLOYEE_TABLE, employeeID);
    }

    @Step("Click Search button")
    public void clickSearchButton() {
        waitForElementClickable(driver, EmployeeListPUI.SEARCH_BUTTON);
        sleep(1);
        clickElement(driver, EmployeeListPUI.SEARCH_BUTTON);
    }

    @Step("Click Edit button")
    public PersonalDetailsPO clickEditButton() {
        waitForElementVisible(driver, EmployeeListPUI.EDIT_BUTTON);
        scrollIntoViewJS(driver, EmployeeListPUI.EDIT_BUTTON);
        waitForElementClickable(driver, EmployeeListPUI.EDIT_BUTTON);
        clickElement(driver, EmployeeListPUI.EDIT_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    @Step("Enter Employee Id: {0}")
    public void enterEmployeeIdTextbox(String employeeId) {
        waitForElementVisible(driver, EmployeeListPUI.EMPLOYEE_ID_SEARCH_TEXTBOX);
        sendKeysElement(driver, EmployeeListPUI.EMPLOYEE_ID_SEARCH_TEXTBOX, employeeId);
        sleep(2);
    }

    @Step("Enter Employee Name: {0}")
    public void enterEmployeeNameTextbox(String employeeName) {
        sleep(2);
        waitForElementVisible(driver, EmployeeListPUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeysElement(driver, EmployeeListPUI.EMPLOYEE_NAME_TEXTBOX, employeeName);

    }

    @Step("Verify employee '{0}' is displayed")
    public boolean isEmployeeDisplayed(String employeeName) {
        waitForElementVisible(driver, EmployeeListPUI.FIRSTNAME_IN_EMPLOYEE_TABLE);
        scrollIntoViewJS(driver, EmployeeListPUI.FIRSTNAME_IN_EMPLOYEE_TABLE);
        sleep(2);
        List<String> firstNames = getElementsText(driver, EmployeeListPUI.FIRSTNAME_IN_EMPLOYEE_TABLE);
        List<String> lastNames = getElementsText(driver, EmployeeListPUI.LASTNAME_IN_EMPLOYEE_TABLE);
        for (int i = 0; i < firstNames.size(); i++) {
            String firstName = firstNames.get(i).toLowerCase();
            String lastName = lastNames.get(i).toLowerCase();
            String fullName = (firstName + " " + lastName).toLowerCase();
            if (firstName.contains(employeeName.trim().toLowerCase()) || lastName.contains(employeeName.trim().toLowerCase())
                    || fullName.contains(employeeName.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Step("Get search result message")
    public String getSearchResultMessage() {
        waitForElementVisible(driver, EmployeeListPUI.SEARCH_RESULT_MESSAGE);
        scrollIntoViewJS(driver, EmployeeListPUI.SEARCH_RESULT_MESSAGE);
        sleep(2);
        return getElementText(driver, EmployeeListPUI.SEARCH_RESULT_MESSAGE);
    }
}
