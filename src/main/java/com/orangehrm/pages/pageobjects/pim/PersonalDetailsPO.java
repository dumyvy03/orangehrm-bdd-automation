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
        return getAttributeValue(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameValue() {
        return getAttributeValue(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, "value");
    }

    public boolean isAvatarUploaded(Dimension avatarBeforeSize) {
        Dimension avatarAfterUploadSize = getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return !avatarAfterUploadSize.equals(avatarBeforeSize);
    }

    public void enterFirstNameTextbox(String firstName) {
        sendKeysElement(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, firstName);
        sleep(1);
    }

    public void enterLastNameTextbox(String lastName) {
        sendKeysElement(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, lastName);
        sleep(1);
    }

    public void enterDriverLicenseTextbox(String driverLicense) {
        sendKeysElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, driverLicense);
        sleep(1);
    }

    public void enterLicenseExpiryDateTextbox(String licenseExpiryDate) {
        sendKeysElement(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);
        sleep(1);
    }

    public void selectNationalityDropdown(String nationality) {
        selectDropdownCustomer(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPUI.NATIONALITY_DROPDOWN_CHILD, nationality);
        sleep(1);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        selectDropdownCustomer(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
        sleep(1);
    }

    public void enterDateOfBirthTextbox(String dateOfBirth) {
        sendKeysElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
        sleep(1);
    }

    public void selectGenderRadioButton(String gender) {
        checkElementByJS(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        sleep(1);
    }

    public String getDriverLicenseNumberValue() {
        return getAttributeValue(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateValue() {
        return getAttributeValue(driver, PersonalDetailsPUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    public String getSelectedNationalityText() {
        return getElementText(driver, PersonalDetailsPUI.NATIONALITY_SELECTED_TEXT);
    }

    public String getSelectedMaritalStatusText() {
        return getElementText(driver, PersonalDetailsPUI.MARITAL_STATUS_SELECTED_TEXT);
    }

    public String getDateOfBirthValue() {
        return getAttributeValue(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public boolean isGenderSelected(String gender) {
        return isElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }

    public void clickSaveButtonPersonalDetails() {
        clickElement(driver, PersonalDetailsPUI.SAVE_PERSONAL_DETAILS_BUTTON);
        waitForLoadingIconInvisible(driver);
    }

    public ChangeProfilePicturePO openChangeProfilePicturePage() {
        clickElement(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return PageGenerator.getChangeProfilePicturePage(driver);
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
    }

    public String getLicenseExpiryDateErrorMessage() {
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
