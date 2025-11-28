package com.orangehrm.pages.pim;

import com.orangehrm.core.PageGenerator;
import com.orangehrm.ui.pim.PersonalDetailsPUI;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PersonalDetailsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get First Name value")
    public String getFirstNameValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, "value");
    }

    @Step("Get Last Name value")
    public String getLastNameValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, "value");
    }

    @Step("Verify Avatar is uploaded successfully")
    public boolean isAvatarUploaded(Dimension avatarBeforeSize) {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        Dimension avatarAfterUploadSize = getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return !avatarAfterUploadSize.equals(avatarBeforeSize);
    }

    @Step("Enter First Name: {0}")
    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        sendKeysElement(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, firstName);
        sleep(1);
    }

    @Step("Enter Last Name: {0}")
    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        sendKeysElement(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, lastName);
        sleep(1);
    }

    @Step("Enter DriverLicense: {0}")
    public void enterDriverLicenseTextbox(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        sendKeysElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, driverLicense);
        sleep(1);
    }

    @Step("Enter LicenseExpiryDate: {0}")
    public void enterLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendKeysElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);
        sleep(1);
    }

    @Step("Select Nationality: {0}")
    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        selectDropdownCustomer(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPUI.NATIONALITY_DROPDOWN_CHILD, nationality);
        sleep(1);
    }

    @Step("Select Marital Status: {0}")
    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectDropdownCustomer(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
        sleep(1);
    }

    @Step("Enter Date Of Birth: {0}")
    public void enterDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeysElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
        sleep(1);
    }

    @Step("Selct Gender: {0}")
    public void selectGenderRadioButton(String gender) {
        checkElementByJS(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        sleep(1);
    }

    @Step("Get Driver License value")
    public String getDriverLicenseValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    @Step("Get License Expiry Date value")
    public String getLicenseExpiryDateValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    @Step("Get selected nationality")
    public String getSelectedNationalityText() {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_SELECTED_TEXT);
        return getElementText(driver, PersonalDetailsPUI.NATIONALITY_SELECTED_TEXT);
    }

    @Step("Get selected marital status")
    public String getSelectedMaritalStatusText() {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_SELECTED_TEXT);
        return getElementText(driver, PersonalDetailsPUI.MARITAL_STATUS_SELECTED_TEXT);
    }

    @Step("Get Date Of Birth value")
    public String getDateOfBirthValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    @Step("Verify gender '{0}' is selected")
    public boolean isGenderSelected(String gender) {
        waitForElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }

    @Step("Click Save button")
    public void clickSaveButton() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_PERSONAL_DETAILS_BUTTON);
        clickElement(driver, PersonalDetailsPUI.SAVE_PERSONAL_DETAILS_BUTTON);
        waitForLoadingIconInvisible(driver);
    }

    @Step("Open Change Profile Picture Page")
    public ChangeProfilePicturePO openChangeProfilePicturePage() {
        waitForElementClickable(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        clickElement(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return PageGenerator.getChangeProfilePicturePage(driver);
    }

    @Step("Get Avatar size")
    public Dimension getAvatarSize() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
    }

    @Step("Get License Expiry Date error message")
    public String getLicenseExpiryDateErrorMessage() {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_ERROR_MESSAGE);
        return getElementText(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_ERROR_MESSAGE);
    }

    @Step("Enter personal details")
    public void enterPersonalDetails(Map<String, String> updatedData) {
        enterFirstNameTextbox(updatedData.get("First Name"));
        enterLastNameTextbox(updatedData.get("Last Name"));
        enterDriverLicenseTextbox(updatedData.get("Driver's License Number"));
        enterLicenseExpiryDateTextbox(updatedData.get("License Expiry Date"));
        selectNationalityDropdown(updatedData.get("Nationality"));
        selectMaritalStatusDropdown(updatedData.get("Marital Status"));
        enterDateOfBirthTextbox(updatedData.get("Date of Birth"));
        selectGenderRadioButton(updatedData.get("Gender"));
    }

    @Step("Get First Name error message")
    public String getFirstNameErrorMessage() {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_ERROR_MESSAGE);
        return getElementText(driver, PersonalDetailsPUI.FIRSTNAME_ERROR_MESSAGE);
    }

    @Step("Click Employee List link")
    public EmployeeListPO clickEmployeeListLink(WebDriver driver) {
        waitForElementClickable(driver, PersonalDetailsPUI.EMPLOYEE_LIST_LINK);
        clickElement(driver, PersonalDetailsPUI.EMPLOYEE_LIST_LINK);
        return PageGenerator.getEmployeeListPage(driver);
    }

    public void waitPersonalDetailsPageLoaded() {
        waitForLoadingIconInvisible(driver);
    }
}
