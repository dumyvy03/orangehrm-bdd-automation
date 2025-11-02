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
        clickElement(driver, EmployeeListPUI.DELETE_BUTTON_BY_ID, employeeID);
    }

    public void clickConfirmDeleteButton() {
        sleep(1);
        clickElement(driver, EmployeeListPUI.CONFIRM_DELETE_BUTTON);
    }

    public boolean isEmployeeDeleted(String employeeID) {
        waitForLoadingIconInvisible(driver);
        return isElementUnDisplayed(driver, EmployeeListPUI.EMPLOYEE_ID_IN_EMPLOYEE_TABLE, employeeID);
    }

    public void clickSearchButton() {
        sleep(1);
        clickElement(driver, EmployeeListPUI.SEARCH_BUTTON);
    }

    public PersonalDetailsPO clickEditButtonEmployeeList() {
        scrollPageToBottomByJS(driver);
        sleep(1);
        clickElement(driver, EmployeeListPUI.EDIT_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public void enterEmployeeIdTextbox(String employeeId) {
        sendKeysElement(driver, EmployeeListPUI.EMPLOYEE_ID_SEARCH_TEXTBOX, employeeId);
    }
}
