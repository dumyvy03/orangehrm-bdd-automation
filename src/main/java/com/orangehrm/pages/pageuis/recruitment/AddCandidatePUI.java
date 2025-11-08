package com.orangehrm.pages.pageuis.recruitment;

public class AddCandidatePUI {
    public static final String FIRSTNAME_TEXTBOX = "Css=input.orangehrm-firstname";

    public static final String LASTNAME_TEXTBOX = "Css=input.orangehrm-lastname";

    public static final String VACANCY_DROPDOWN_PARENT = "Xpath=//label[text()='Vacancy']/parent::div/following-sibling::div//i";
    public static final String VACANCY_DROPDOWN_CHILD = "Xpath=//label[text()='Vacancy']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";

    public static final String EMAIL_TEXTBOX = "Xpath=//label[text()='Email']/parent::div/following-sibling::div/input";

    public static final String CONTACT_NUMBER_TEXTBOX = "Xpath=//label[text()='Contact Number']/parent::div/following-sibling::div/input";

    public static final String KEYWORDS_TEXTBOX = "Xpath=//label[text()='Keywords']/parent::div/following-sibling::div/input";

    public static final String DATE_OF_APPLICATION_TEXTBOX = "Xpath=//label[text()='Date of Application']/parent::div/following-sibling::div//input";

    public static final String NOTES_TEXTAREA = "Xpath=//label[text()='Notes']/parent::div/following-sibling::div/textarea";

    public static final String SAVE_BUTTON = "Xpath=//button[normalize-space(.)='Save']";

    public static final String EMAIL_ERR0R_TEXT = "Xpath=//label[text()='Email']/parent::div/following-sibling::span[contains(@class,'oxd-input-field-error-message')]";

    public static final String RESUME_ERROR_TEXT = "Xpath=//label[text()='Resume']/parent::div/following-sibling::span[contains(@class,'oxd-input-field-error-message')]";

    public static final String CONTACT_NUMBER_ERR0R_TEXT = "Xpath=//label[text()='Contact Number']/parent::div/following-sibling::span[contains(@class,'oxd-input-field-error-message')]";


}
