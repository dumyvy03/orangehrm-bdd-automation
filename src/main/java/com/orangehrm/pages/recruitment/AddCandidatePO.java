package com.orangehrm.pages.recruitment;

import com.orangehrm.core.BasePage;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.ui.recruitment.AddCandidatePUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddCandidatePO extends BasePage {
    private WebDriver driver;

    public AddCandidatePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter First Name: {0}")
    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddCandidatePUI.FIRSTNAME_TEXTBOX);
        sendKeysElement(driver, AddCandidatePUI.FIRSTNAME_TEXTBOX, firstName);
        sleep(1);
    }

    @Step("Enter Last Name: {0}")
    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddCandidatePUI.LASTNAME_TEXTBOX);
        sendKeysElement(driver, AddCandidatePUI.LASTNAME_TEXTBOX, lastName);
        sleep(1);
    }

    @Step("Select Vacancy: {0}")
    public void selectVacancyDropdown(String vacancy) {
        waitForElementClickable(driver, AddCandidatePUI.VACANCY_DROPDOWN_PARENT);
        selectDropdownCustomer(driver, AddCandidatePUI.VACANCY_DROPDOWN_PARENT, AddCandidatePUI.VACANCY_DROPDOWN_CHILD, vacancy);
        sleep(1);
    }

    @Step("Enter Email: {0}")
    public void enterEmailTextbox(String email) {
        waitForElementVisible(driver, AddCandidatePUI.EMAIL_TEXTBOX);
        sendKeysElement(driver, AddCandidatePUI.EMAIL_TEXTBOX, email);
        sleep(1);
    }

    @Step("Enter Contact Number: {0}")
    public void enterContactNumberTextbox(String contactNumber) {
        waitForElementVisible(driver, AddCandidatePUI.CONTACT_NUMBER_TEXTBOX);
        sendKeysElement(driver, AddCandidatePUI.CONTACT_NUMBER_TEXTBOX, contactNumber);
        sleep(1);
    }

    @Step("Upload Resume: {0}")
    public void uploadResumeFile(String resume) {
        handleFileUpload(driver, resume);
        sleep(1);
    }

    @Step("Enter Keywords: {0}")
    public void enterKeywordsTextbox(String keywords) {
        waitForElementVisible(driver, AddCandidatePUI.KEYWORDS_TEXTBOX);
        sendKeysElement(driver, AddCandidatePUI.KEYWORDS_TEXTBOX, keywords);
        sleep(1);
    }

    @Step("Enter Notes: {0}")
    public void enterNotesTextarea(String notes) {
        waitForElementVisible(driver, AddCandidatePUI.NOTES_TEXTAREA);
        sendKeysElement(driver, AddCandidatePUI.NOTES_TEXTAREA, notes);
        sleep(1);
    }

    @Step("Enter candidate information")
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

    @Step("Click Save button")
    public CandidateProfilePO clickSaveButton() {
        waitForElementClickable(driver, AddCandidatePUI.SAVE_BUTTON);
        sleep(1);
        clickElement(driver, AddCandidatePUI.SAVE_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getCandidateProfilePage(driver);
    }

    @Step("Get Date Of Application value")
    public String getDateOfApplicationValue() {
        waitForElementVisible(driver, AddCandidatePUI.DATE_OF_APPLICATION_TEXTBOX);
        return getAttributeValue(driver, AddCandidatePUI.DATE_OF_APPLICATION_TEXTBOX, "value");
    }

    @Step("Get Email error message")
    public String getEmailErrorMessage() {
        waitForElementVisible(driver, AddCandidatePUI.EMAIL_ERR0R_MESSSAGE);
        return getElementText(driver, AddCandidatePUI.EMAIL_ERR0R_MESSSAGE);
    }

    @Step("Get Resume error message")
    public String getResumeErrorMessage() {
        waitForElementVisible(driver, AddCandidatePUI.RESUME_ERROR_MESSAGE);
        return getElementText(driver, AddCandidatePUI.RESUME_ERROR_MESSAGE);
    }

    @Step("Get Contact Number error message")
    public String getContactNumberErrorMessage() {
        waitForElementVisible(driver, AddCandidatePUI.CONTACT_NUMBER_ERR0R_MESSAGE);
        return getElementText(driver, AddCandidatePUI.CONTACT_NUMBER_ERR0R_MESSAGE);
    }
}
