package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.pim.PersonalDetailsPUI;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PersonalDetailsPO extends EmployeeNavigationPO {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameValue() {
        waitForElementPresence(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameValue() {
        waitForElementPresence(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, "value");
    }

    public boolean isAvatarUploaded(Dimension avatarBeforeSize) {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        Dimension avatarAfterUploadSize = getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return !avatarAfterUploadSize.equals(avatarBeforeSize);
    }

    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterDriverLicenseTextbox(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, driverLicense);
    }

    public void enterLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);

    }

    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        sleep(1);
        selectDropdownCustomer(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPUI.NATIONALITY_DROPDOWN_CHILD, nationality);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        sleep(1);
        selectDropdownCustomer(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
    }

    public void enterDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        clearTextbox(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectGenderRadioButton(String gender) {
        waitForElementClickable(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON);
        sleep(1);
        checkElementByJS(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }

    public String getDriverLicenseNumberValue() {
        waitForElementPresence(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateValue() {
        waitForElementPresence(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    public String getSelectedNationalityText() {
        waitForElementPresence(driver, PersonalDetailsPUI.NATIONALITY_SELECTED_TEXT);
        return getElementText(driver, PersonalDetailsPUI.NATIONALITY_SELECTED_TEXT);
    }

    public String getSelectedMaritalStatusText() {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_SELECTED_TEXT);
        return getElementText(driver, PersonalDetailsPUI.MARITAL_STATUS_SELECTED_TEXT);
    }

    public String getDateOfBirthValue() {
        waitForElementPresence(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        return getAttributeValue(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public boolean isGenderSelected(String gender) {
        waitForElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }

    public void clickSaveButtonPersonalDetails() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_PERSONAL_DETAILS_BUTTON);
        clickElement(driver, PersonalDetailsPUI.SAVE_PERSONAL_DETAILS_BUTTON);
        waitForLoadingIconInvisible(driver);
    }

    public ChangeProfilePicturePO openChangeProfilePicturePage() {
        waitForElementClickable(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        clickElement(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return PageGenerator.getChangeProfilePicturePage(driver);
    }

    public Dimension getAvatarSize() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
    }

    public String getLicenseExpiryDateErrorMessage() {
        waitForElementVisible(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_ERROR_TEXT);
        return getElementText(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_ERROR_TEXT);
    }

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

}
