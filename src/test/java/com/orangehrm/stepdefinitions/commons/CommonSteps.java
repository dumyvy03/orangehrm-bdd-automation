package com.orangehrm.stepdefinitions.commons;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.LoginPO;
import com.orangehrm.pages.pageobjects.commons.CommonPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonSteps {
    private final CommonPO commonPage;
    private final LoginPO loginPage;
    private final TestContext testContext;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = PageGenerator.getLoginPage(testContext.getDriver());
        commonPage = PageGenerator.getCommonPage(testContext.getDriver());
    }

    private DashboardPO login(String username, String password) {
        loginPage.openLoginPage();
        loginPage.enterCredentials(username, password);
        return loginPage.clickLoginButton();
    }

    @Then("the system should display the field error message {string}")
    public void theSystemShouldDisplayTheFieldErrorMessage(String errorMessage) {
        Assert.assertEquals(commonPage.getErrorMessage(), errorMessage);
        testContext.getScenarioContext().setDataMap("errorMessage", errorMessage);
    }

    @Given("the admin has successfully logged in")
    public void theAdminHasSuccessfullyLoggedIn() {
        testContext.getPageContext()
                .setDashboardPage(login("admin", "Admin@1234"));
        Assert.assertTrue(testContext.getPageContext().getDashboardPage().isDashboardVisible());
    }

}
