package com.orangehrm.pages.pageobjects.recruitment;

import com.orangehrm.commons.BasePage;
import com.orangehrm.pages.pageuis.recruitment.CandidateProfilePUI;
import org.openqa.selenium.WebDriver;

public class CandidateProfilePO extends BasePage {
    private WebDriver driver;

    public CandidateProfilePO(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameValue() {
        return getAttributeValue(driver, CandidateProfilePUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameValue() {
        return getAttributeValue(driver, CandidateProfilePUI.LASTNAME_TEXTBOX, "value");
    }

    public String getJobVacancyText() {
        return getElementText(driver, CandidateProfilePUI.JOB_VACANCY_SELECTED_TEXT);
    }

    public String getEmailValue() {
        return getAttributeValue(driver, CandidateProfilePUI.EMAIL_TEXTBOX, "value");
    }

    public String getContactNumberValue() {
        return getAttributeValue(driver, CandidateProfilePUI.CONTACT_NUMBER_TEXTBOX, "value");
    }

    public String getUploadedResumeFileName() {
        return getAttributeValue(driver, CandidateProfilePUI.RESUME_UPLOADED_FILE_NAME, "innerText").trim();
    }

    public String getKeywordsValue() {
        return getAttributeValue(driver, CandidateProfilePUI.KEYWORDS_TEXTBOX, "value");
    }

    public String getDateOfApplicationValue() {
        return getAttributeValue(driver, CandidateProfilePUI.DATE_OF_APPLICATION_TEXTBOX, "value");
    }

    public String getNotesValue() {
        return getAttributeValue(driver, CandidateProfilePUI.NOTES_TEXTAREA, "value");
    }
}
