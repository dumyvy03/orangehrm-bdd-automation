package com.orangehrm.steps.admin;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.admin.AddUserPO;
import com.orangehrm.pages.admin.UserManagementPO;
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
    public void clickOpenAddUserPage() {
        addUserPage = userManagementPage.clickAddButton();
    }

    @When("the admin enters and selects the following user details:")
    public void enterUserInformation(DataTable dataTable) {
        Map<String, String> userInformationData = dataTable.asMap(String.class, String.class);
        userName = userInformationData.get("Username");
        addUserPage.enterUserInformation(userInformationData);
    }

    @And("clicks the Save button to create the new user")
    public void clickSaveNewUser() {
        userManagementPage = addUserPage.clickSaveButton();
    }

    @Then("the newly created user is displayed in the user list")
    public void verifyNewUserIsDisplayedInUserList() {
        Assert.assertTrue(userManagementPage.isUsernameDisplayed(userName));
    }

    @When("the admin enters username {string} on the Add User page")
    public void enterUsername(String userName) {
        addUserPage.enterUserNameTextbox(userName);
    }

    @When("the admin enters password {string} on the Add User page")
    public void enterPassword(String password) {
        addUserPage.enterPasswordTextbox(password);
    }

    @When("the admin enters password {string} and confirm password {string}")
    public void enterPasswordAndConfirm(String password, String confirmPassword) {
        addUserPage.enterPasswordTextbox(password);
        addUserPage.enterConfirmPasswordTextbox(confirmPassword);
    }

    @Then("the Add User confirm password field displays the error {string}")
    public void verifyConfirmPasswordErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addUserPage.getConfirmPasswordErrorMessage(), errorMessage);
    }

    @When("the admin enters employee name {string} on the Add User page")
    public void enterEmployeeName(String employeeName) {
        addUserPage.enterEmployeeNameTextbox(employeeName);
    }

    @Then("the suggestions dropdown displays {string}")
    public void verifySuggestionDropdownMessage(String message) {
        Assert.assertEquals(addUserPage.getSuggestionDropdownMessage(), message);
    }

    @Then("the Add User username field displays the error {string}")
    public void verifyUsernameErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addUserPage.getUsernameErrorMessage(), errorMessage);
    }

    @Then("the Add User password field displays the error {string}")
    public void verifyPasswordErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addUserPage.getPasswordErrorMessage(), errorMessage);
    }

}
