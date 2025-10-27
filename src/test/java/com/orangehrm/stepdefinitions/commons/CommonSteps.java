package com.orangehrm.stepdefinitions.commons;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.LoginPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class CommonSteps {
    private final TestContext testContext;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    private DashboardPO login(String username, String password) {
        LoginPO loginPage = PageGenerator.getLoginPage(testContext.getDriver());
        loginPage.openLoginPage();
        loginPage.enterCredentials(username, password);
        return loginPage.clickLoginButton();
    }

    @Given("the admin has successfully logged in")
    public void theAdminHasSuccessfullyLoggedIn() {
        DashboardPO dashboardPO = login("admin", "Admin@1234");
        Assert.assertTrue(dashboardPO.isDashboardVisible());
    }
}
