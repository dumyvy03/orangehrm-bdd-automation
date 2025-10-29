package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.pim.EmployeeNavigationPUI;
import org.openqa.selenium.WebDriver;

public class EmployeeNavigationPO extends BasePage {
    private WebDriver driver;

    public EmployeeNavigationPO(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailsPO openPersonalDetailsPage() {
        clickElement(driver, EmployeeNavigationPUI.PERSONAL_DETAILS_LINK);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

}
