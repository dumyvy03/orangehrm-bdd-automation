package com.orangehrm.steps.pim;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.pim.AddEmployeePO;
import com.orangehrm.pages.pim.PersonalDetailsPO;
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

    @And("clicks Add Employee page")
    public void clicksAddEmployeePage() {
        addEmployeePage = PageGenerator.getEmployeeListPage(DriverFactory.getDriver())
                .openAddEmployeePage();
        employeeId = addEmployeePage.getEmployeeIdValue();
    }

    @When("the admin enters the employee name with first name {string} and last name {string}")
    public void enterEmployeeName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        addEmployeePage.enterEmployeeDetails(firstName, lastName);
    }

    @When("the admin uploads the avatar {string}")
    @And("uploads the avatar {string}")
    public void uploadAvatar(String avatar) {
        this.avatarBeforeSize = addEmployeePage.getAvatarSize();
        addEmployeePage.uploadAvatar(avatar);
    }

    @And("clicks the Save button to create the new employee")
    public void clickSaveNewEmployee() {
        personalDetailsPage = addEmployeePage.clickSaveButton();
    }

    @Then("the Personal Details page displays the employee’s information")
    public void verifyEmployeeDetailsDisplayed() {
        personalDetailsPage.waitPersonalDetailsPageLoaded();
        Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastNameValue(), lastName);
        Assert.assertTrue(personalDetailsPage.isAvatarUploaded(avatarBeforeSize));
        isEmployeeCreated = true;
    }

    @Then("the Add Employee first name field displays the error {string}")
    public void verifyFirstNameErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addEmployeePage.getFirstNameErrorMessage(), errorMessage);
    }

    @Then("the Add Employee last name field displays the error {string}")
    public void verifyLastNamedErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addEmployeePage.getLastNameErrorMessage(), errorMessage);
    }

    @Then("the Add Employee avatar field displays the error {string}")
    public void verifyAvatarErrorDisplayed(String errorMessage) {
        Assert.assertEquals(addEmployeePage.getAvatarErrorMessage(), errorMessage);
    }

}
