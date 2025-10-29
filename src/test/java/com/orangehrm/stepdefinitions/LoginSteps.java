package com.orangehrm.stepdefinitions;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.LoginPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
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

    @Then("the system redirects to the admin dashboard")
    public void verifyAdminDashboardDisplayed() {
        Assert.assertTrue(dashboardPage.isDashboardVisible());
    }

    @Then("the system displays the login error message {string}")
    public void verifyLoginErrorMessage(String errorMessage) {
        Assert.assertEquals(loginPage.getLoginErrorMessage(), errorMessage);
    }

    @Then("the username field shows error {string}")
    public void verifyUsernameErrorMessage(String errorMessage) {
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), errorMessage);
    }

    @Then("the password field shows error {string}")
    public void verifyPasswordShowsError(String errorMessage) {
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), errorMessage);
    }
}
