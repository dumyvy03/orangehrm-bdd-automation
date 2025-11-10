package com.orangehrm.stepdefinitions.commons;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.commons.ValidationPO;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ValidationSteps {
    private final ValidationPO validationPage;

    public ValidationSteps(TestContext testContext) {
        this.validationPage = PageGenerator.getValidationPage(testContext.getDriver());
    }

    @Then("the first name field shows error {string}")
    public void verifyFirstNameFieldShowsError(String errorMessage) {
        Assert.assertEquals(validationPage.getFirstNameErrorMessage(), errorMessage);
    }

    @Then("the username field shows error {string}")
    public void verifyUsernameErrorMessage(String errorMessage) {
        Assert.assertEquals(validationPage.getUsernameErrorMessage(), errorMessage);
    }

    @Then("the password field shows error {string}")
    public void verifyPasswordShowsError(String errorMessage) {
        Assert.assertEquals(validationPage.getPasswordErrorMessage(), errorMessage);
    }
}
