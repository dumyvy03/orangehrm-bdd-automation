package com.orangehrm.stepdefinitions.pim;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.pim.AddEmployeePO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

public class AddEmployeeSteps {
    private AddEmployeePO addEmployeePage;
    private String firstName, lastName;
    private Dimension avatarBeforeSize;
    private PersonalDetailsPO personalDetailsPage;
    public static String employeeId;
    public static boolean isEmployeeCreated;

    @And("navigates to the Add New Employee page")
    public void navigatesToAddNewEmployeePage() {
        addEmployeePage = PageGenerator.getSidebarPage(DriverFactory.getDriver())
                .openPIMPage()
                .openAddEmployeePage();
    }

    @When("the admin enters the employee name first name {string} last name {string} and uploads the avatar {string}")
    public void entersEmployeeNameAndUploadsAvatar(String firstName, String lastName, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatarBeforeSize = addEmployeePage.getAvatarSize();
        employeeId = addEmployeePage.getEmployeeIdValue();
        addEmployeePage.enterEmployeeDetails(firstName, lastName, avatar);
    }

    @And("clicks the Save button to add a new employee")
    public void clicksSaveButton() {
        personalDetailsPage = addEmployeePage.clickSaveButton();
    }

    @Then("the Personal Details page displays the employee’s details")
    public void verifyEmployeeDetailsDisplayed() {
        Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastNameValue(), lastName);
        Assert.assertTrue(personalDetailsPage.isAvatarUploaded(avatarBeforeSize));
        isEmployeeCreated = true;
    }

    @Then("the last name field shows error {string}")
    public void verifyLastNamedErrorMessage(String errorMessage) {
        Assert.assertEquals(addEmployeePage.getLastNameErrorMessage(), errorMessage);
    }

    @Then("the avatar field shows error {string}")
    public void verifyAvatarFieldShowsError(String errorMessage) {
        Assert.assertEquals(addEmployeePage.getAvatarErrorMessage(), errorMessage);
    }
    
    @When("the admin enters the employee name first name {string} last name {string}")
    public void theAdminEntersTheEmployeeNameFirstNameLastName(String firstName, String lastName) {
        addEmployeePage.enterFirstNameTextbox(firstName);
        addEmployeePage.enterLastNameTextbox(lastName);
    }

    @When("the admin uploads the avatar {string}")
    public void theAdminUploadsTheAvatar(String avatarPath) {
        addEmployeePage.uploadAvatar(avatarPath);
    }
}
