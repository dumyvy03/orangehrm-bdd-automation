package com.orangehrm.stepdefinitions.pim;

import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import com.orangehrm.context.TestContext;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

public class PersonalDetailsSteps {
    private final TestContext testContext;

    public PersonalDetailsSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("the Personal Details page displays the employee’s details")
    public void thePersonalDetailsPageDisplaysTheEmployeeSDetails() {
        PersonalDetailsPO personalDetailsPage = testContext.getPageContext().getPersonalDetailsPage();
        String firstName = (String) testContext.getScenarioContext().get("firstName");
        String lastName = (String) testContext.getScenarioContext().get("lastName");
        String id = (String) testContext.getScenarioContext().get("id");
        Dimension avatarBeforeSize = (Dimension) testContext.getScenarioContext().get("avatarBeforeSize");
        Assert.assertEquals(personalDetailsPage.getFirstNameTextbox(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastNameTextbox(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeIdAtDetailsPage(), id);
        Assert.assertTrue(personalDetailsPage.isAvatarUploadSuccess(avatarBeforeSize));
    }


}
