package com.orangehrm.stepdefinitions.admin;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.admin.UserManagementPO;
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
    public void theAdminSearchesForTheUser(String username) {
        userManagementPage.enterUserNameTextbox(username);
        userManagementPage.clickSearchButton();
    }

    @And("clicks the Delete button to remove selected user")
    public void clicksTheDeleteButtonToRemoveSelectedUser() {
        userManagementPage.clickDeleteSelectedButton();
    }

    @And("confirms the deletion")
    public void confirmsTheDeletion() {
        userManagementPage.clickConfirmButton();
    }

    @And("clicks the Delete button to remove user")
    public void clicksTheDeleteButtonToRemoveUser() {
        userManagementPage.clickDeleteButton();
    }

    @Then("the system removes the user {string} from the user list")
    public void theSystemRemovesTheUserFromTheUserList(String username) {
        Assert.assertTrue(userManagementPage.isUserRemoved(username));
    }

    @When("the admin selects multiple users from the user list")
    public void theAdminSelectsMultipleUsersFromTheUserList(DataTable dataTable) {
        Map<String, String> usernameData = dataTable.asMap(String.class, String.class);
        userManagementPage
                .selectUsersByUsernames(
                        usernameData.get("Username1"),
                        usernameData.get("Username2")
                );
    }

    @Then("the system removes all selected users from the user list")
    public void theSystemRemovesAllSelectedUsersFromTheUserList(DataTable dataTable) {
        Map<String, String> usernameData = dataTable.asMap(String.class, String.class);
        Assert.assertTrue(userManagementPage.areUsersRemoved(usernameData));
    }


    @And("cancels the deletion")
    public void cancelsTheDeletion() {
        userManagementPage.clickCancelButton();
    }

    @Then("the user {string} still appears in the user list")
    public void theUserStillAppearsInTheUserList(String username) {
        Assert.assertTrue(userManagementPage.isUserDisplayed(username));
    }

}
