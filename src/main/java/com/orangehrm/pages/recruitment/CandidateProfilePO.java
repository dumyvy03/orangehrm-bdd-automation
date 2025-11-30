package com.orangehrm.pages.recruitment;

import com.orangehrm.core.BasePage;
import com.orangehrm.ui.recruitment.CandidateProfilePUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CandidateProfilePO extends BasePage {
    private WebDriver driver;

    public CandidateProfilePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get First Name value")
    public String getFirstNameValue() {
        waitForElementVisible(driver, CandidateProfilePUI.FIRSTNAME_TEXTBOX);
        return getAttributeValue(driver, CandidateProfilePUI.FIRSTNAME_TEXTBOX, "value");
    }

    @Step("Get Last Name value")
    public String getLastNameValue() {
        waitForElementVisible(driver, CandidateProfilePUI.LASTNAME_TEXTBOX);
        return getAttributeValue(driver, CandidateProfilePUI.LASTNAME_TEXTBOX, "value");
    }

    @Step("Get Job Vacancy text")
    public String getJobVacancyText() {
        waitForElementVisible(driver, CandidateProfilePUI.JOB_VACANCY_SELECTED_TEXT);
        return getElementText(driver, CandidateProfilePUI.JOB_VACANCY_SELECTED_TEXT);
    }

    @Step("Get Email value")
    public String getEmailValue() {
        waitForElementVisible(driver, CandidateProfilePUI.EMAIL_TEXTBOX);
        return getAttributeValue(driver, CandidateProfilePUI.EMAIL_TEXTBOX, "value");
    }

    @Step("Get Contact Number value")
    public String getContactNumberValue() {
        waitForElementVisible(driver, CandidateProfilePUI.CONTACT_NUMBER_TEXTBOX);
        return getAttributeValue(driver, CandidateProfilePUI.CONTACT_NUMBER_TEXTBOX, "value");
    }

    @Step("Get uploaded Resume file name")
    public String getUploadedResumeFileName() {
        waitForElementVisible(driver, CandidateProfilePUI.RESUME_UPLOADED_FILE_NAME);
        return getAttributeValue(driver, CandidateProfilePUI.RESUME_UPLOADED_FILE_NAME, "innerText").trim();
    }

    @Step("Get Keywords value")
    public String getKeywordsValue() {
        waitForElementVisible(driver, CandidateProfilePUI.KEYWORDS_TEXTBOX);
        return getAttributeValue(driver, CandidateProfilePUI.KEYWORDS_TEXTBOX, "value");
    }

    @Step("Get Date Of Application value")
    public String getDateOfApplicationValue() {
        waitForElementVisible(driver, CandidateProfilePUI.DATE_OF_APPLICATION_TEXTBOX);
        return getAttributeValue(driver, CandidateProfilePUI.DATE_OF_APPLICATION_TEXTBOX, "value");
    }

    @Step("Get Notes value")
    public String getNotesValue() {
        waitForElementVisible(driver, CandidateProfilePUI.DATE_OF_APPLICATION_TEXTBOX);
        return getAttributeValue(driver, CandidateProfilePUI.NOTES_TEXTAREA, "value");
    }
}
