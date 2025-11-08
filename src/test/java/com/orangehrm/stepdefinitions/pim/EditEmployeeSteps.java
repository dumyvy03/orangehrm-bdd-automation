package com.orangehrm.stepdefinitions.pim;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.pim.ChangeProfilePicturePO;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import java.util.Map;

public class EditEmployeeSteps {
    private final TestContext testContext;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;

    String firstName, lastName, driverLicense, licenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    Dimension avatarBeforeUploadSize;

    public EditEmployeeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("navigates to the Employee List page")
    public void navigatesToTheEmployeeListPage() {
        employeeListPage = PageGenerator.getSidebarPage(testContext.getDriver()).openPIMPage();
    }

    @When("the admin searches by employee id {string}")
    public void theAdminSearchesByEmployeeId(String employeeId) {
        employeeListPage.enterEmployeeIdTextbox(employeeId);
    }

    @And("the admin clicks the Search button")
    public void theAdminClicksTheSearchButton() {
        employeeListPage.clickSearchButton();
    }

    @And("clicks Edit button in search results")
    public void clicksEditButton() {
        personalDetailsPage = employeeListPage.clickEditButtonEmployeeList();
    }

    @And("the admin updates personal details")
    public void updatesEmployeeInformation(DataTable dataTable) {
        Map<String, String> updatedData = dataTable.asMap(String.class, String.class);
        String avatarPath = updatedData.get("Avatar");
        avatarBeforeUploadSize = personalDetailsPage.getAvatarSize();
        ChangeProfilePicturePO changeProfilePicturePage = personalDetailsPage.openChangeProfilePicturePage();
        changeProfilePicturePage.uploadAvatar(avatarPath);
        personalDetailsPage = changeProfilePicturePage.openPersonalDetailsPage();

        firstName = updatedData.get("First Name");
        lastName = updatedData.get("Last Name");
        driverLicense = updatedData.get("Driver's License Number");
        licenseExpiryDate = updatedData.get("License Expiry Date");
        nationality = updatedData.get("Nationality");
        maritalStatus = updatedData.get("Marital Status");
        dateOfBirth = updatedData.get("Date of Birth");
        gender = updatedData.get("Gender");

        personalDetailsPage.enterPersonalDetails(updatedData);
    }

    @And("clicks the Save button to update")
    public void theAdminClicksTheSaveButtonToUpdate() {
        personalDetailsPage.clickSaveButtonPersonalDetails();
    }

    @Then("the system saves the updated information successfully")
    public void verifyUpdatedInformation() {
        Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastNameValue(), lastName);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseNumberValue(), driverLicense);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateValue(), licenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getSelectedNationalityText(), nationality);
        Assert.assertEquals(personalDetailsPage.getSelectedMaritalStatusText(), maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthValue(), dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderSelected(gender));
        Assert.assertTrue(personalDetailsPage.isAvatarUploaded(avatarBeforeUploadSize));
    }

    @And("the admin updates license expiry date {string}")
    public void theAdminUpdatesLicenseExpiryDate(String licenseExpiryDate) {
        personalDetailsPage.enterLicenseExpiryDateTextbox(licenseExpiryDate);
    }

    @And("the admin updates date of birth {string}")
    public void theAdminUpdatesDateOfBirth(String dateOfBirth) {
        personalDetailsPage.enterDateOfBirthTextbox(dateOfBirth);
    }

    @And("the admin updates first name empty {string}")
    public void theAdminUpdatesFirstNameEmpty(String firstName) {
        personalDetailsPage.enterFirstNameTextbox(firstName);
    }

    @Then("the license expiry date field shows error {string}")
    public void verifyLicenseExpiryDateFieldShowsError(String errorMessage) {
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateErrorMessage(), errorMessage);
    }


    @Then("the date of birth field shows error {string}")
    public void verifyDateOfBirthFieldShowsError(String errorMessage) {
        Assert.assertEquals(personalDetailsPage.getDateOfBirthErrorMessage(), errorMessage);
    }
}
