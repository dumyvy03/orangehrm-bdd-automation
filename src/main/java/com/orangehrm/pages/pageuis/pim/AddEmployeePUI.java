package com.orangehrm.pages.pageuis.pim;

public class AddEmployeePUI {
    public static final String EMPLOYEE_ID_TEXTBOX = "Xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String FIRSTNAME_TEXTBOX = "Css=input.orangehrm-firstname";
    public static final String LASTNAME_TEXTBOX = "Css=input.orangehrm-lastname";
    public static final String SAVE_BUTTON_ADD_EMPLOYEE = "Xpath=//h6[text()='Add Employee']/following-sibling::form//button[contains(string(),'Save')]";
    public static final String EMPLOYEE_AVATAR = "Css=div.employee-image-wrapper>img.employee-image";
    public static final String FIRSTNAME_ERROR_MESSAGE = "Xpath=//input[@name='firstName']/parent::div/following-sibling::span";
    public static final String LASTNAME_ERROR_MESSAGE = "Xpath=//input[@name='lastName']/parent::div/following-sibling::span";
    public static final String AVATAR_ERROR_MESSAGE = "Xpath=//img[@class='employee-image']/ancestor::div[contains(@class,'oxd-file-div')]/parent::div/following-sibling::span";
}