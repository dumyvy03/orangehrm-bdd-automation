package com.orangehrm.pages.pageobjects.dashboard;

import com.orangehrm.pages.pageobjects.commons.SidebarPO;
import com.orangehrm.pages.pageuis.dashboard.DashboardPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPO extends SidebarPO {
    private final WebDriver driver;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        waitListForElementsVisible(driver, DashboardPUI.DASHBOARD_WIDGETS);
        List<WebElement> widgets = getElements(driver, DashboardPUI.DASHBOARD_WIDGETS);
        return !widgets.isEmpty();
    }

}
