package com.orangehrm.core;

import com.orangehrm.pages.admin.AddUserPO;
import com.orangehrm.pages.admin.UserManagementPO;
import com.orangehrm.pages.sidebar.SidebarPO;
import com.orangehrm.pages.dashboard.DashboardPO;
import com.orangehrm.pages.login.LoginPO;
import com.orangehrm.pages.pim.AddEmployeePO;
import com.orangehrm.pages.pim.ChangeProfilePicturePO;
import com.orangehrm.pages.pim.EmployeeListPO;
import com.orangehrm.pages.pim.PersonalDetailsPO;
import com.orangehrm.pages.recruitment.AddCandidatePO;
import com.orangehrm.pages.recruitment.CandidateProfilePO;
import com.orangehrm.pages.recruitment.CandidatesPO;
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
