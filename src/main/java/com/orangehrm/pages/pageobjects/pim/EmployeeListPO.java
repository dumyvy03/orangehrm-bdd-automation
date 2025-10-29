package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.pim.EmployeeListPUI;
import org.openqa.selenium.WebDriver;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddEmployeePO openAddEmployeePage() {
        sleep(2);
        clickElement(driver, EmployeeListPUI.ADD_EMPLOYEE_LINK);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getAddEmployeePage(driver);
    }

    public void clickDeleteEmployeeButton(String employeeID) {
        scrollPageToBottomByJS(driver);
        sleep(1);
        clickElement(driver, EmployeeListPUI.DYNAMIC_DELETE_BUTTON_BY_ID, employeeID);
    }

    public void clickConfirmDeleteButton() {
        sleep(1);
        clickElement(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
    }

    public boolean isEmployeeDeleted(String employeeID) {
        waitForLoadingIconInvisible(driver);
        return isElementUnDisplayed(driver, EmployeeListPUI.DYNAMIC_EMPLOYEE_ID, employeeID);
    }

    public void enterEmployeeNameTextbox(String employeeName) {
        sleep(3);
        sendKeysElement(driver, EmployeeListPUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
    }

    public void selectSubUnitDropdown(String subUnit) {
        sleep(2);
        selectDropdownCustomer(driver, EmployeeListPUI.SUB_UNIT_DROPDOWN_PARENT, EmployeeListPUI.SUB_UNIT_DROPDOWN_CHILD, subUnit);
    }

    public void clickSearchButton() {
        sleep(1);
        clickElement(driver, EmployeeListPUI.SEARCH_BUTTON);
    }

    public PersonalDetailsPO clickEditButtonEmployeeList(String employeeId) {
        scrollPageToBottomByJS(driver);
        sleep(1);
        clickElement(driver, EmployeeListPUI.DYNAMIC_EDIT_BUTTON_BY_ID, employeeId);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
