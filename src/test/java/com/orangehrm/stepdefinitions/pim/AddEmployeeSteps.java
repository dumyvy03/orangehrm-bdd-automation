package com.orangehrm.stepdefinitions.pim;

import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.pim.AddEmployeePO;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;

public class AddEmployeeSteps {
    private final TestContext testContext;
    private AddEmployeePO addEmployeePage;

    public AddEmployeeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    private void saveEmployeeData(String firstName, String lastName, String id, Dimension avatarBeforeSize) {
        testContext.getScenarioContext().setDataMap("firstName", firstName);
        testContext.getScenarioContext().setDataMap("lastName", lastName);
        testContext.getScenarioContext().setDataMap("id", id);
        testContext.getScenarioContext().setDataMap("avatarBeforeSize", avatarBeforeSize);
    }

    @And("navigates to the Add New Employee page")
    public void navigatesToTheAddNewEmployeePage() {
        EmployeeListPO employeeListPage = testContext.getPageContext().getDashboardPage().openPIMPage();
        addEmployeePage = employeeListPage.openAddEmployeePage();
    }

    @When("the admin enters the employee name {string} {string} and uploads the avatar {string}")
    public void theAdminEntersTheEmployeeNameAndUploadsTheAvatar(String firstName, String lastName, String avatar) {
        Dimension avatarBeforeSize = addEmployeePage.getAvatarSize();
        String employeeId = addEmployeePage.getEmployeeIdTextbox();
        addEmployeePage.enterEmployeeDetails(firstName, lastName, avatar);
        saveEmployeeData(firstName, lastName, employeeId, avatarBeforeSize);
    }

    @And("clicks the Save button on the Add Employee page")
    public void clicksTheSaveButtonOnTheAddEmployeePage() {
        PersonalDetailsPO personalDetailsPage = addEmployeePage.clickSaveButton();
        testContext.getPageContext().setPersonalDetailsPage(personalDetailsPage);
    }
}
