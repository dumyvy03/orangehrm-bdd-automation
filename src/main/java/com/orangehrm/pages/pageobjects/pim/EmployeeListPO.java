package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.pim.EmployeeListPUI;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddEmployeePO openAddEmployeePage() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_LINK);
        sleep(2);
        clickElement(driver, EmployeeListPUI.ADD_EMPLOYEE_LINK);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getAddEmployeePage(driver);
    }

    public void clickDeleteEmployeeButton(String employeeID) {
        scrollToElement(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
        waitForElementClickable(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
        sleep(1);
        clickElement(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
    }

    public void clickConfirmDeleteButton() {
        waitForElementClickable(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
        sleep(1);
        clickElement(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
    }

    public boolean isEmployeeDeleted(String employeeID) {
        waitForLoadingIconInvisible(driver);
        waitForElementInVisible(driver, EmployeeListPUI.EMPLOYEE_ID_IN_EMPLOYEE_TABLE, employeeID);
        return isElementUnDisplayed(driver, EmployeeListPUI.EMPLOYEE_ID_IN_EMPLOYEE_TABLE, employeeID);
    }

    public void clickSearchButton() {
        waitForElementClickable(driver, EmployeeListPUI.SEARCH_BUTTON);
        sleep(1);
        clickElement(driver, EmployeeListPUI.SEARCH_BUTTON);
    }

    public PersonalDetailsPO clickEditButtonEmployeeList() {
        scrollToElement(driver, EmployeeListPUI.EDIT_BUTTON);
        waitForElementClickable(driver, EmployeeListPUI.EDIT_BUTTON);
        sleep(1);
        clickElement(driver, EmployeeListPUI.EDIT_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public void enterEmployeeIdTextbox(String employeeId) {
        waitForElementVisible(driver, EmployeeListPUI.EMPLOYEE_ID_SEARCH_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, EmployeeListPUI.EMPLOYEE_ID_SEARCH_TEXTBOX, employeeId);
    }

    public void enterEmployeeNameTextbox(String employeeName) {
        waitForElementVisible(driver, EmployeeListPUI.EMPLOYEE_NAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, EmployeeListPUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
    }

    public boolean isEmployeeDisplayed(String employeeName) {
        waitForElementVisible(driver, EmployeeListPUI.FIRSTNAME_IN_EMPLOYEE_TABLE);
        scrollToElement(driver, EmployeeListPUI.FIRSTNAME_IN_EMPLOYEE_TABLE);
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
}
