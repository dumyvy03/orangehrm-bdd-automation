package com.orangehrm.stepdefinitions.pim;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchEmployeeSteps {
    private final TestContext testContext;
    private EmployeeListPO employeeListPage;

    public SearchEmployeeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("the admin enters employee name {string}")
    public void theAdminEntersEmployeeName(String employeeName) {
        employeeListPage = PageGenerator.getEmployeeListPage(testContext.getDriver());
        employeeListPage.enterEmployeeNameTextbox(employeeName);
    }

    @And("clicks Search button")
    public void clicksSearchButton() {
        employeeListPage.clickSearchButton();
    }

    @Then("the results list shows employee with name {string}")
    public void verifyResultsListShowsEmployeeWithName(String employeeName) {
        Assert.assertTrue(employeeListPage.isEmployeeDisplayed(employeeName));
    }

    @Then("the system shows {string}")
    public void verifytheSystemShowsError(String errorMessage) {
        Assert.assertEquals(employeeListPage.getErrorSearchMessage(), errorMessage);
    }
}
