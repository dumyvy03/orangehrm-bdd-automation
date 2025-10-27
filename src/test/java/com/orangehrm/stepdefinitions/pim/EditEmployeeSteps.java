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
    private ChangeProfilePicturePO changeProfilePicturePage;

    String firstName, lastName, driverLicense, licenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    Dimension avatarBeforeUploadSize;

    public EditEmployeeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("navigates to the Employee List page")
    public void navigatesToTheEmployeeListPage() {
        employeeListPage = PageGenerator.getSidebarPage(testContext.getDriver()).openPIMPage();
    }

    @When("the admin searches by {string} and {string}")
    public void theAdminSearchesByAnd(String employeeName, String subUnit) {
        employeeListPage.enterEmployeeNameTextbox(employeeName);
        employeeListPage.selectSubUnitDropdown(subUnit);
    }

    @And("the admin clicks the Search button")
    public void theAdminClicksTheSearchButton() {
        employeeListPage.clickSearchButton();
    }

    @And("clicks Edit button for {string} in results list")
    public void clicksEditButtonForInResultsList(String employeeId) {
        personalDetailsPage = employeeListPage.clickEditButtonEmployeeList(employeeId);
    }

    @And("the admin uploads avatar {string}")
    public void theAdminUploadsAvatar(String avatarPath) {
        avatarBeforeUploadSize = personalDetailsPage.getAvatarSize();
        changeProfilePicturePage = personalDetailsPage.openChangeProfilePicturePage();
        changeProfilePicturePage.uploadAvatar(avatarPath);

    }

    @And("the admin updates personal details")
    public void updatesEmployeeInformation(DataTable dataTable) {
        personalDetailsPage = changeProfilePicturePage.openPersonalDetailsPage();
        Map<String, String> updatedData = dataTable.asMap(String.class, String.class);
        firstName = updatedData.get("First Name");
        lastName = updatedData.get("Last Name");
        driverLicense = updatedData.get("Driver's License Number");
        licenseExpiryDate = updatedData.get("License Expiry Date");
        nationality = updatedData.get("Nationality");
        maritalStatus = updatedData.get("Marital Status");
        dateOfBirth = updatedData.get("Date of Birth");
        gender = updatedData.get("Gender");

        personalDetailsPage.enterFirstNameTextbox(firstName);
        personalDetailsPage.enterLastNameTextbox(lastName);
        personalDetailsPage.enterDriverLicenseTextbox(driverLicense);
        personalDetailsPage.enterLicenseExpiryDateTextbox(licenseExpiryDate);
        personalDetailsPage.selectNationalityDropdown(nationality);
        personalDetailsPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailsPage.enterDateOfBirthTextbox(dateOfBirth);
        personalDetailsPage.selectGenderRadioButton(gender);
    }

    @And("the admin clicks the Save button to update personal details")
    public void theAdminClicksTheSaveButtonToUpdate() {
        personalDetailsPage.clickSaveButtonPersonalDetails();
    }

    @Then("the system saves the updated information successfully")
    public void verifyUpdatedInformation() {
        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseNumberValue(), driverLicense);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateValue(), licenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getSelectedNationalityText(), nationality);
        Assert.assertEquals(personalDetailsPage.getSelectedMaritalStatusText(), maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthValue(), dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderSelected(gender));
        Assert.assertTrue(personalDetailsPage.isAvatarUploadSuccess(avatarBeforeUploadSize));
    }

}
