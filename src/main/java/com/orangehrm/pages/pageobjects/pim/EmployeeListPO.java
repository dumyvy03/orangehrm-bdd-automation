package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.commons.SidebarPO;
import com.orangehrm.pages.pageuis.pim.EmployeeListPUI;
import org.openqa.selenium.WebDriver;

public class EmployeeListPO extends SidebarPO {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddEmployeePO openAddEmployeePage() {
        sleep(1);
        clickElement(driver, EmployeeListPUI.ADD_EMPLOYEE_LINK);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getAddEmployeePage(driver);
    }

    public void clickDeleteEmployeeButton(String employeeID) {
        scrollIntoView(driver, EmployeeListPUI.DYNAMIC_DELETE_BUTTON_BY_ID, employeeID);
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
}
