package com.orangehrm.commons;

import com.orangehrm.pages.pageobjects.LoginPO;
import com.orangehrm.pages.pageobjects.SidebarPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageobjects.pim.AddEmployeePO;
import com.orangehrm.pages.pageobjects.pim.ChangeProfilePicturePO;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import org.openqa.selenium.WebDriver;

public class PageGenerator {

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
        return new AddEmployeePO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPO(driver);
    }

    public static SidebarPO getSidebarPage(WebDriver driver) {
        return new SidebarPO(driver);
    }

    public static ChangeProfilePicturePO getChangeProfilePicturePage(WebDriver driver) {
        return new ChangeProfilePicturePO(driver);
    }

}
