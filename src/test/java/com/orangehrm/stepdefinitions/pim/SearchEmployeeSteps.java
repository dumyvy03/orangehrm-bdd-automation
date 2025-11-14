package com.orangehrm.stepdefinitions.pim;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchEmployeeSteps {
    private EmployeeListPO employeeListPage;

    public SearchEmployeeSteps() {
        employeeListPage = PageGenerator.getEmployeeListPage(DriverFactory.getDriver());
    }

    @When("the admin enters employee name {string} on Employee List page")
    public void theAdminEntersEmployeeName(String employeeName) {
        employeeListPage.enterEmployeeNameTextbox(employeeName);
    }

    @And("clicks the Search button to find the employee")
    public void clicksSearchButton() {
        employeeListPage.clickSearchButton();
    }

    @Then("the results list shows employee with name {string}")
    public void verifyResultsListShowsEmployeeWithName(String employeeName) {
        Assert.assertTrue(employeeListPage.isEmployeeDisplayed(employeeName));
    }

}
