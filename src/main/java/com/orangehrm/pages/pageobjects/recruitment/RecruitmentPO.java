package com.orangehrm.pages.pageobjects.recruitment;

import com.orangehrm.pages.pageobjects.commons.SidebarPO;
import org.openqa.selenium.WebDriver;

public class RecruitmentPO extends SidebarPO {
    private WebDriver driver;

    public RecruitmentPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
