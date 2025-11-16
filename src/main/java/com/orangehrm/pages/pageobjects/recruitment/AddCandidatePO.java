package com.orangehrm.pages.pageobjects.recruitment;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.recruitment.AddCandidatePUI;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddCandidatePO extends BasePage {
    private WebDriver driver;

    public AddCandidatePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddCandidatePUI.FIRSTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, AddCandidatePUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddCandidatePUI.LASTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, AddCandidatePUI.LASTNAME_TEXTBOX, lastName);
    }

    public void selectVacancyDropdown(String vacancy) {
        waitForElementClickable(driver, AddCandidatePUI.VACANCY_DROPDOWN_PARENT);
        sleep(1);
        selectDropdownCustomer(driver, AddCandidatePUI.VACANCY_DROPDOWN_PARENT, AddCandidatePUI.VACANCY_DROPDOWN_CHILD, vacancy);
    }

    public void enterEmailTextbox(String email) {
        waitForElementVisible(driver, AddCandidatePUI.EMAIL_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, AddCandidatePUI.EMAIL_TEXTBOX, email);
    }

    public void enterContactNumberTextbox(String contactNumber) {
        waitForElementVisible(driver, AddCandidatePUI.CONTACT_NUMBER_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, AddCandidatePUI.CONTACT_NUMBER_TEXTBOX, contactNumber);
    }

    public void uploadResumeFile(String resume) {
        sleep(1);
        handleFileUpload(driver, resume);
    }

    public void enterKeywordsTextbox(String keywords) {
        waitForElementVisible(driver, AddCandidatePUI.KEYWORDS_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, AddCandidatePUI.KEYWORDS_TEXTBOX, keywords);
    }

    public void enterNotesTextarea(String notes) {
        waitForElementVisible(driver, AddCandidatePUI.NOTES_TEXTAREA);
        sleep(1);
        sendKeysElement(driver, AddCandidatePUI.NOTES_TEXTAREA, notes);
    }

    public void enterCandidateInformation(Map<String, String> addCandidateData) {
        enterFirstNameTextbox(addCandidateData.get("First Name"));
        enterLastNameTextbox(addCandidateData.get("Last Name"));
        selectVacancyDropdown(addCandidateData.get("Vacancy"));
        enterEmailTextbox(addCandidateData.get("Email"));
        enterContactNumberTextbox(addCandidateData.get("Contact Number"));
        uploadResumeFile(addCandidateData.get("Resume"));
        enterKeywordsTextbox(addCandidateData.get("Keywords"));
        enterNotesTextarea(addCandidateData.get("Notes"));
    }

    public CandidateProfilePO clickSaveButton() {
        waitForElementClickable(driver, AddCandidatePUI.SAVE_BUTTON);
        sleep(1);
        clickElement(driver, AddCandidatePUI.SAVE_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getCandidateProfilePage(driver);
    }

    public String getDateOfApplicationValue() {
        waitForElementPresence(driver, AddCandidatePUI.DATE_OF_APPLICATION_TEXTBOX);
        return getAttributeValue(driver, AddCandidatePUI.DATE_OF_APPLICATION_TEXTBOX, "value");
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, AddCandidatePUI.EMAIL_ERR0R_TEXT);
        sleep(2);
        return getElementText(driver, AddCandidatePUI.EMAIL_ERR0R_TEXT);
    }

    public String getResumeErrorMessage() {
        waitForElementVisible(driver, AddCandidatePUI.RESUME_ERROR_TEXT);
        sleep(2);
        return getElementText(driver, AddCandidatePUI.RESUME_ERROR_TEXT);
    }

    public String getContactNumberErrorMessage() {
        waitForElementVisible(driver, AddCandidatePUI.CONTACT_NUMBER_ERR0R_TEXT);
        sleep(2);
        return getElementText(driver, AddCandidatePUI.CONTACT_NUMBER_ERR0R_TEXT);
    }
}
