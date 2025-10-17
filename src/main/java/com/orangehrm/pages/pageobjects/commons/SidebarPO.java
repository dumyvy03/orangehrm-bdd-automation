package com.orangehrm.pages.pageobjects.commons;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageuis.commons.SidebarPUI;
import org.openqa.selenium.WebDriver;

public class SidebarPO extends BasePage {
    private WebDriver driver;

    public SidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPO openPIMPage() {
        sleep(2);
        clickElement(driver, SidebarPUI.PIM_LINK);
        return PageGenerator.getEmployeeListPage(driver);
    }

}
