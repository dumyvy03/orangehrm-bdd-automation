package com.orangehrm.stepdefinitions;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.LoginPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private final TestContext testContext;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
    }


    @Given("the admin is on the login page")
    public void theAdminIsOnTheLoginPage() {
        loginPage = PageGenerator.getLoginPage(testContext.getDriver());
        loginPage.openLoginPage();
    }

    @When("the admin enters username {string} and password {string}")
    public void theAdminEntersUsernameAndPassword(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("clicks the Login button")
    public void clicksLoginButton() {
        dashboardPage = loginPage.clickLoginButton();
    }

    @Then("the system should redirect to the admin dashboard")
    public void theSystemShouldRedirectToTheAdminDashboard() {
        Assert.assertTrue(dashboardPage.isDashboardVisible());
    }

    @Then("the system should display the login error message {string}")
    public void theSystemShouldDisplayTheLoginErrorMessage(String errorMessage) {
        Assert.assertEquals(loginPage.getLoginErrorMessage(), errorMessage);
    }
}
