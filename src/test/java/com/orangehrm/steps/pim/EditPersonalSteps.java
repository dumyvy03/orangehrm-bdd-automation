package com.orangehrm.steps.pim;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.pim.ChangeProfilePicturePO;
import com.orangehrm.pages.pim.EmployeeListPO;
import com.orangehrm.pages.pim.PersonalDetailsPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import java.util.Map;

public class EditPersonalSteps {
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;

    String firstName, lastName, driverLicense, licenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    Dimension avatarBeforeUploadSize;

    public EditPersonalSteps() {
        employeeListPage = PageGenerator.getEmployeeListPage(DriverFactory.getDriver());
    }

    @When("the admin searches for the employee by ID {string}")
    public void enterEmployeeId(String employeeId) {
        employeeListPage.enterEmployeeIdTextbox(employeeId);
    }

    @And("clicks the Search button to find the employee for editing")
    public void clickSearch() {
        employeeListPage.clickSearchButton();
    }

    @And("clicks the Edit button in the search results")
    public void clickEditEmployee() {
        personalDetailsPage = employeeListPage.clickEditButton();
    }

    @And("the admin updates the following personal details:")
    public void updateEmployeeInformation(DataTable dataTable) {
        Map<String, String> updatedData = dataTable.asMap(String.class, String.class);
        avatarBeforeUploadSize = personalDetailsPage.getAvatarSize();
        ChangeProfilePicturePO changeProfilePicturePage = personalDetailsPage.openChangeProfilePicturePage();
        changeProfilePicturePage.uploadAvatar(updatedData.get("Avatar"));
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
    public void clickSaveUpdate() {
        personalDetailsPage.clickSaveButton();
    }

    @Then("the system saves the updated information successfully")
    public void verifyUpdatedInformation() {
        Assert.assertEquals(personalDetailsPage.getFirstNameValue(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastNameValue(), lastName);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseValue(), driverLicense);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateValue(), licenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getSelectedNationalityText(), nationality);
        Assert.assertEquals(personalDetailsPage.getSelectedMaritalStatusText(), maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthValue(), dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderSelected(gender));
        Assert.assertTrue(personalDetailsPage.isAvatarUploaded(avatarBeforeUploadSize));
    }

    @And("the admin updates the license expiry date with {string}")
    public void enterLicenseExpiryDate(String licenseExpiryDate) {
        personalDetailsPage.enterLicenseExpiryDateTextbox(licenseExpiryDate);
    }

    @And("the admin updates the first name with {string}")
    public void enterFirstName(String firstName) {
        personalDetailsPage.enterFirstNameTextbox(firstName);
    }

    @Then("the Personal Details license expiry date field displays the error {string}")
    public void verifyLicenseExpiryDateErrorDisplayed(String errorMessage) {
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateErrorMessage(), errorMessage);
    }

    @Then("the Personal Details first name field displays the error {string}")
    public void verifyFirstNameErrorDisplayed(String errorMessage) {
        Assert.assertEquals(personalDetailsPage.getFirstNameErrorMessage(), errorMessage);
    }
}
