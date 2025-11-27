package com.orangehrm.steps.common;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.dashboard.DashboardPO;
import com.orangehrm.pages.login.LoginPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PreconditionSteps {

    private final WebDriver driver;

    public PreconditionSteps() {
        driver = DriverFactory.getDriver();
    }

    private DashboardPO login(String username, String password) {
        LoginPO loginPage = PageGenerator.getLoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterCredentials(username, password);
        return loginPage.clickLoginButton();
    }

    @Given("the admin has successfully logged in")
    public void adminLoggedIn() {
        DashboardPO dashboardPO = login("admin", "Admin@1234");
        Assert.assertTrue(dashboardPO.isDashboardVisible());
    }

    @And("navigates to the Employee List page")
    public void navigateToEmployeeListPage() {
        PageGenerator.getSidebarPage(driver).openPIMPage();
    }

    @And("navigates to the User Management page")
    public void navigateToAdminPage() {
        PageGenerator.getSidebarPage(driver).openAdminPage();
    }

    @And("navigates to the Candidate page")
    public void navigateToCandidatePage() {
        PageGenerator.getSidebarPage(driver).openRecruitmentPage();
    }
}
