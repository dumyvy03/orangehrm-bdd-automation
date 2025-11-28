package com.orangehrm.steps.admin;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.admin.UserManagementPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchUserSteps {
    private UserManagementPO userManagementPage;

    public SearchUserSteps() {
        userManagementPage = PageGenerator.getUserManagementPage(DriverFactory.getDriver());
    }

    @When("the admin enters username {string} on the User Management page")
    public void enterUsername(String username) {
        userManagementPage.enterUserNameTextbox(username);
    }

    @And("clicks the Search button to find the user")
    @When("the admin clicks the Search button to find the user")
    public void clickSearchUser() {
        userManagementPage.clickSearchButton();
    }

    @Then("the username {string} appears in the results list")
    public void verifyUsernameIsShownInResults(String username) {
        Assert.assertTrue(userManagementPage.isUsernameDisplayed(username));
    }

    @Then("the system displays all existing users")
    public void verifyExistingUsersAreDisplayed() {
        Assert.assertTrue(userManagementPage.isUserListNotEmpty());
    }

    @Then("the search results display {string}")
    public void verifySearchResultsMessageDisplayed(String message) {
        Assert.assertEquals(userManagementPage.getSearchResultMessage(), message);
    }

}
