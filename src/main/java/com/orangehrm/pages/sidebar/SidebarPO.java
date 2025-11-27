package com.orangehrm.pages.sidebar;

import com.orangehrm.core.BasePage;
import com.orangehrm.ui.sibar.SidebarPUI;
import org.openqa.selenium.WebDriver;

public class SidebarPO extends BasePage {
    private WebDriver driver;

    public SidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPIMPage() {
        waitForElementClickable(driver, SidebarPUI.PIM_LINK);
        sleep(1);
        clickElement(driver, SidebarPUI.PIM_LINK);
    }

    public void openRecruitmentPage() {
        waitForElementClickable(driver, SidebarPUI.RECRUITMENT_LINK);
        sleep(1);
        clickElement(driver, SidebarPUI.RECRUITMENT_LINK);
    }

    public void openAdminPage() {
        waitForElementClickable(driver, SidebarPUI.ADMIN_LINK);
        sleep(1);
        clickElement(driver, SidebarPUI.ADMIN_LINK);
    }

}
