package com.orangehrm.stepdefinitions.commons;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.commons.ValidationPO;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ValidationSteps {
    private final TestContext testContext;

    public ValidationSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the first name field shows error {string}")
    public void verifyFirstNameFieldShowsError(String errorMessage) {
        ValidationPO validationPage = PageGenerator.getValidationPage(testContext.getDriver());
        Assert.assertEquals(validationPage.getFirstNameErrorMessage(), errorMessage);
    }
}
