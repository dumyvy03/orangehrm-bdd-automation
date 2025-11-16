package com.orangehrm.pages.pageobjects.commons;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.admin.UserManagementPO;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.recruitment.CandidatesPO;
import com.orangehrm.pages.pageuis.commons.SidebarPUI;
import org.openqa.selenium.WebDriver;

public class SidebarPO extends BasePage {
    private WebDriver driver;

    public SidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPO openPIMPage() {
        waitForElementClickable(driver, SidebarPUI.PIM_LINK);
        sleep(2);
        clickElement(driver, SidebarPUI.PIM_LINK);
        return PageGenerator.getEmployeeListPage(driver);
    }

    public CandidatesPO openRecruitmentPage() {
        waitForElementClickable(driver, SidebarPUI.RECRUITMENT_LINK);
        sleep(2);
        clickElement(driver, SidebarPUI.RECRUITMENT_LINK);
        return PageGenerator.getCandidatesPage(driver);
    }

    public UserManagementPO openAdminPage() {
        waitForElementClickable(driver, SidebarPUI.ADMIN_LINK);
        sleep(2);
        clickElement(driver, SidebarPUI.ADMIN_LINK);
        return PageGenerator.getUserManagementPage(driver);
    }

}
