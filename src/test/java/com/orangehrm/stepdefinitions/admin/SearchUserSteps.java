package com.orangehrm.stepdefinitions.admin;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.admin.UserManagementPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchUserSteps {
    private UserManagementPO userManagementPage;

    public SearchUserSteps() {
        userManagementPage = PageGenerator.getUserManagementPage(DriverFactory.getDriver());
    }

    @When("the admin enters username {string} on User Management page")
    public void theAdminEnterUsername(String username) {
        userManagementPage.enterUserNameTextbox(username);
    }

    @And("clicks the Search button to find the user")
    public void clicksTheSearchButtonToFindTheUser() {
        userManagementPage.clickSearchButton();
    }

    @Then("the username {string} is shown in the results list")
    public void theUsernameIsShownInTheResultsList(String username) {
        Assert.assertTrue(userManagementPage.isUsernameDisplayed(username));
    }

    @When("the admin clicks the Search button to find the user")
    public void theAdminClicksTheSearchButtonToFindTheUser() {
        userManagementPage.clickSearchButton();
    }

    @Then("the system displays all existing users")
    public void theSystemDisplaysAllExistingUsers() {
        Assert.assertTrue(userManagementPage.isUserListNotEmpty());
    }
}
