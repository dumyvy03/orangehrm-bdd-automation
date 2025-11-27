package com.orangehrm.steps.admin;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.admin.UserManagementPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class DeleteUserSteps {
    private UserManagementPO userManagementPage;

    public DeleteUserSteps() {
        userManagementPage = PageGenerator.getUserManagementPage(DriverFactory.getDriver());
    }

    @When("the admin searches for the user {string}")
    public void searchForUser(String username) {
        userManagementPage.enterUserNameTextbox(username);
        userManagementPage.clickSearchButton();
    }

    @And("clicks the Delete button to remove the selected user")
    public void clickDeleteSelectedUser() {
        userManagementPage.clickDeleteSelectedButton();
    }

    @And("confirms the deletion")
    public void clickConfirmDeletion() {
        userManagementPage.clickDeleteConfirmButton();
    }

    @And("clicks the Delete button to remove user")
    public void clickDeleteUser() {
        userManagementPage.clickDeleteButton();
    }

    @When("the admin selects multiple users from the user list")
    public void selectMultipleUsers(DataTable dataTable) {
        Map<String, String> usernameData = dataTable.asMap(String.class, String.class);
        userManagementPage
                .selectUsersByUsernames(
                        usernameData.get("Username1"),
                        usernameData.get("Username2")
                );
    }

    @Then("the system removes all selected users from the user list")
    public void verifySelectedUsersRemoved(DataTable dataTable) {
        Map<String, String> usernameData = dataTable.asMap(String.class, String.class);
        Assert.assertTrue(userManagementPage.areUsersRemoved(usernameData));
    }

    @And("cancels the deletion")
    public void clickCancelDeletion() {
        userManagementPage.clickCancelConfirmButton();
    }

    @Then("the user {string} still appears in the user list")
    public void verifyUserStillAppearsInList(String username) {
        Assert.assertTrue(userManagementPage.isUsernameDisplayed(username));
    }

    @Then("the user table displays {string}")
    public void verifyUserTableMessageDisplayed(String message) {
        Assert.assertEquals(userManagementPage.getSearchResultMessage(), message);
    }

}
