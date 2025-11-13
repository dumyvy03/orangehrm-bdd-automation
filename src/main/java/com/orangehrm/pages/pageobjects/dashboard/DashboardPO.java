package com.orangehrm.pages.pageobjects.dashboard;

import com.orangehrm.commons.BasePage;
import com.orangehrm.pages.pageuis.dashboard.DashboardPUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPO extends BasePage {
    private final WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        waitListForElementsVisible(driver, DashboardPUI.DASHBOARD_WIDGETS);
        sleep(2);
        List<WebElement> widgets = getElements(driver, DashboardPUI.DASHBOARD_WIDGETS);
        return !widgets.isEmpty();
    }

}
