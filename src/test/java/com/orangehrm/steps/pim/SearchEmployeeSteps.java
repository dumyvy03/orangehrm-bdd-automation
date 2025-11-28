package com.orangehrm.steps.pim;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.pim.EmployeeListPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchEmployeeSteps {
    private EmployeeListPO employeeListPage;

    public SearchEmployeeSteps() {
        employeeListPage = PageGenerator.getEmployeeListPage(DriverFactory.getDriver());
    }

    @When("the admin enters the employee name {string} on the Employee List page")
    public void enterEmployeeName(String employeeName) {
        employeeListPage.enterEmployeeNameTextbox(employeeName);
    }

    @And("clicks the Search button to find the employee")
    public void clickSearchEmployee() {
        employeeListPage.clickSearchButton();
    }

    @Then("the results list displays the employee with the name {string}")
    public void verifyEmployeeSearchResults(String employeeName) {
        Assert.assertTrue(employeeListPage.isEmployeeDisplayed(employeeName));
    }

    @Then("the system displays {string} for the employee search")
    public void verifySystemErrorDisplayed(String message) {
        Assert.assertEquals(employeeListPage.getSearchResultMessage(), message);
    }
}
