package com.orangehrm.stepdefinitions.pim;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.pim.AddEmployeePO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

public class AddEmployeeSteps {
    private final TestContext testContext;
    private AddEmployeePO addEmployeePage;
    String firstName, lastName, employeeId;
    Dimension avatarBeforeSize;
    private PersonalDetailsPO personalDetailsPage;

    public AddEmployeeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("navigates to the Add New Employee page")
    public void navigatesToTheAddNewEmployeePage() {
        addEmployeePage = PageGenerator.getEmployeeListPage(testContext.getDriver()).openAddEmployeePage();
    }

    @When("the admin enters the employee name {string} {string} and uploads the avatar {string}")
    public void theAdminEntersTheEmployeeNameAndUploadsTheAvatar(String firstName, String lastName, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = addEmployeePage.getEmployeeIdValue();
        testContext.getScenarioContext().setDataMap("employeeId", employeeId);
        this.avatarBeforeSize = addEmployeePage.getAvatarSize();
        addEmployeePage.enterEmployeeDetails(firstName, lastName, avatar);
    }

    @And("clicks the Save button to add a new employee")
    public void clicksTheSaveButtonToAddANewEmployee() {
        personalDetailsPage = addEmployeePage.clickSaveButtonAddEmployee();
    }

    @Then("the Personal Details page displays the employee’s details")
    public void verifyEmployeeDetailsDisplayed() {
        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeIdAtDetailsPage(), employeeId);
        Assert.assertTrue(personalDetailsPage.isAvatarUploadSuccess(avatarBeforeSize));
    }
}
