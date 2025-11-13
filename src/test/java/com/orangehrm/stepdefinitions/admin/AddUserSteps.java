package com.orangehrm.stepdefinitions.admin;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.admin.AddUserPO;
import com.orangehrm.pages.pageobjects.admin.UserManagementPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class AddUserSteps {
    private UserManagementPO userManagementPage;
    private String userName;
    private AddUserPO addUserPage;

    public AddUserSteps() {
        userManagementPage = PageGenerator.getUserManagementPage(DriverFactory.getDriver());
    }

    @And("clicks the Add button to open the Add User page")
    public void theAdminClicksTheAddButtonToOpenTheAddUserForm() {
        addUserPage = userManagementPage.clickAddButton();
    }

    @When("the admin enters and selects user information")
    public void entersAndSelectsUserInformation(DataTable dataTable) {
        Map<String, String> userInformationData = dataTable.asMap(String.class, String.class);
        userName = userInformationData.get("Username");
        addUserPage.enterUserInformation(userInformationData);
    }

    @And("clicks the Save button to add a new user")
    public void clicksTheSaveButtonToAddANewUser() {
        userManagementPage = addUserPage.clickSaveButton();
    }

    @Then("the new user is displayed in the user list")
    public void theNewUserIsDisplayedInTheUserList() {
        Assert.assertTrue(userManagementPage.isUserNameDisplayed(userName));
    }

    @When("the admin enters username {string} on Add User page")
    public void entersUsername(String userName) {
        addUserPage.enterUserNameTextbox(userName);
    }

    @When("the admin enters password {string} on Add User page")
    public void entersPassword(String password) {
        addUserPage.enterPasswordTextbox(password);
    }

    @When("the admin enters password {string} and confirm password {string}")
    public void entersPasswordAndConfirmPassword(String password, String confirmPassword) {
        addUserPage.enterPasswordTextbox(password);
        addUserPage.enterConfirmPasswordTextbox(confirmPassword);
    }

    @Then("the confirm password field shows error {string}")
    public void theConfirmPasswordFieldShowsError(String errorMessage) {
        Assert.assertEquals(addUserPage.getConfirmPasswordErrorMessage(), errorMessage);
    }


    @When("the admin enters employee name {string} on Add User page")
    public void theAdminEntersEmployeeNameOnAddUserPage(String employeeName) {
        addUserPage.enterEmployeeNameTextbox(employeeName);
    }


    @Then("the suggestions dropdown displays {string}")
    public void verifySuggestionsDropdownDisplays(String recordsMessage) {
        Assert.assertEquals(addUserPage.getSuggestionDropdownMessage(), recordsMessage);
    }
}
