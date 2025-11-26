package com.orangehrm.pages.dashboard;

import com.orangehrm.core.BasePage;
import com.orangehrm.ui.dashboard.DashboardPUI;
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
        List<WebElement> widgets = getElements(driver, DashboardPUI.DASHBOARD_WIDGETS);
        sleep(2);
        return !widgets.isEmpty();
    }

}
