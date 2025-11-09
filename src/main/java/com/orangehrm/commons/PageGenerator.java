package com.orangehrm.commons;

import com.orangehrm.pages.pageobjects.admin.AddUserPO;
import com.orangehrm.pages.pageobjects.admin.UserManagementPO;
import com.orangehrm.pages.pageobjects.commons.SidebarPO;
import com.orangehrm.pages.pageobjects.commons.ValidationPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageobjects.login.LoginPO;
import com.orangehrm.pages.pageobjects.pim.AddEmployeePO;
import com.orangehrm.pages.pageobjects.pim.ChangeProfilePicturePO;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import com.orangehrm.pages.pageobjects.recruitment.AddCandidatePO;
import com.orangehrm.pages.pageobjects.recruitment.CandidateProfilePO;
import com.orangehrm.pages.pageobjects.recruitment.CandidatesPO;
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

    public static ValidationPO getValidationPage(WebDriver driver) {
        return new ValidationPO(driver);
    }

    public static AddCandidatePO getAddCandidatePage(WebDriver driver) {
        return new AddCandidatePO(driver);
    }

    public static CandidatesPO getCandidatesPage(WebDriver driver) {
        return new CandidatesPO(driver);
    }

    public static CandidateProfilePO getCandidateProfilePage(WebDriver driver) {
        return new CandidateProfilePO(driver);
    }

    public static UserManagementPO getUserManagementPage(WebDriver driver) {
        return new UserManagementPO(driver);
    }

    public static AddUserPO getAddUserPage(WebDriver driver) {
        return new AddUserPO(driver);
    }
}
