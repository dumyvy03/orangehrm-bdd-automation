package com.orangehrm.pages.pageuis.admin;

public class AddUserPUI {
    public static final String USER_ROLE_DROPDOWN_PARENT = "Xpath=//label[text()='User Role']/parent::div/following-sibling::div//i";
    public static final String USER_ROLE_DROPDOWN_CHILD = "Xpath=//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";

    public static final String EMPLOYEE_NAME_TEXTBOX = "Xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//input";

    public static final String EMPLOYEE_NAME_SUGGESTION_DROPDOWN = "Xpath=//div[contains(@class,'oxd-autocomplete-dropdown')]/div[@class='oxd-autocomplete-option']/span";

    public static final String STATUS_DROPDOWN_PARENT = "Xpath=//label[text()='Status']/parent::div/following-sibling::div//i";
    public static final String STATUS_DROPDOWN_CHILD = "Xpath=//label[text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";

    public static final String USERNAME_TEXTBOX = "Xpath=//label[text()='Username']/parent::div/following-sibling::div//input";

    public static final String PASSWORD_TEXTBOX = "Xpath=//label[text()='Password']/parent::div/following-sibling::div//input";

    public static final String CONFIRM_PASSWORD_TEXTBOX = "Xpath=//label[text()='Confirm Password']/parent::div/following-sibling::div//input";

    public static final String SAVE_BUTTON = "Xpath=//button[normalize-space(.)='Save']";

    public static final String EMPLOYEE_NAME_NO_RECORDS = "Xpath=//div[contains(@class,'oxd-autocomplete-dropdown')]/div[@class='oxd-autocomplete-option']";

    public static final String CONFIRM_PASSWORD_ERROR_TEXT = "Xpath=//label[text()='Confirm Password']/parent::div/following-sibling::span";
}
