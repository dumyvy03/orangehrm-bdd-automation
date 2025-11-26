package com.orangehrm.steps.login;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.dashboard.DashboardPO;
import com.orangehrm.pages.login.LoginPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private LoginPO loginPage;
    private DashboardPO dashboardPage;

    @Given("the admin is on the login page")
    public void adminIsOnLoginPage() {
        loginPage = PageGenerator.getLoginPage(DriverFactory.getDriver());
        loginPage.openLoginPage();
    }

    @When("the admin enters username {string} and password {string}")
    public void enterUsernameAndPassword(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("clicks the Login button")
    public void clickLogin() {
        dashboardPage = loginPage.clickLoginButton();
    }

    @Then("the system redirects the admin dashboard")
    public void verifyAdminDashboardDisplayed() {
        Assert.assertTrue(dashboardPage.isDashboardVisible());
    }

    @Then("the system displays the login error message {string}")
    public void verifyLoginErrorDisplayed(String errorMessage) {
        Assert.assertEquals(loginPage.getLoginErrorMessage(), errorMessage);
    }

    @Then("the Login username field displays the error {string}")
    public void verifyUsernameErrorDisplayed(String errorMessage) {
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), errorMessage);
    }

    @Then("the Login password field displays the error {string}")
    public void verifyPasswordErrorDisplayed(String errorMessage) {
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), errorMessage);
    }


}
