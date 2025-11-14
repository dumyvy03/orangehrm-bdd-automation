package com.orangehrm.stepdefinitions.commons;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageobjects.login.LoginPO;
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
    public void theAdminHasSuccessfullyLoggedIn() {
        DashboardPO dashboardPO = login("admin", "Admin@1234");
        Assert.assertTrue(dashboardPO.isDashboardVisible());
    }

    @And("navigates to the Employee List page")
    public void navigatesToTheEmployeeListPage() {
        PageGenerator.getSidebarPage(driver).openPIMPage();
    }

    @And("navigates to the User Management page")
    public void navigatesToTheAdminPage() {
        PageGenerator.getSidebarPage(driver).openAdminPage();
    }
}
