package com.orangehrm.commons;

import com.orangehrm.pages.pageobjects.LoginPO;
import com.orangehrm.pages.pageobjects.commons.CommonPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageobjects.pim.AddEmployeePO;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import com.orangehrm.pages.pageobjects.recruitment.RecruitmentPO;
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

    public static RecruitmentPO getRecruitmentPage(WebDriver driver) {
        return new RecruitmentPO(driver);
    }

    public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
        return new AddEmployeePO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPO(driver);
    }

    public static CommonPO getCommonPage(WebDriver driver) {
        return new CommonPO(driver);
    }

}
