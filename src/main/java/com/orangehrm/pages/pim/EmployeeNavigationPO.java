package com.orangehrm.pages.pim;

import com.orangehrm.core.BasePage;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.ui.pim.EmployeeNavigationPUI;
import org.openqa.selenium.WebDriver;

public class EmployeeNavigationPO extends BasePage {
    private WebDriver driver;

    public EmployeeNavigationPO(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailsPO openPersonalDetailsPage() {
        waitForElementVisible(driver, EmployeeNavigationPUI.PERSONAL_DETAILS_LINK);
        clickElement(driver, EmployeeNavigationPUI.PERSONAL_DETAILS_LINK);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

}
