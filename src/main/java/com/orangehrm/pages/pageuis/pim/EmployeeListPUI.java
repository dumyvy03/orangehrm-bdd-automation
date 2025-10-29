package com.orangehrm.pages.pageuis.pim;

public class EmployeeListPUI {
    public static final String ADD_EMPLOYEE_LINK = "Xpath=//a[text()='Add Employee']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_ID = "Xpath=//div[text()='%s']/parent::div/following-sibling::div//button/i[contains(@class,'bi-trash')]";
    public static final String DYNAMIC_EDIT_BUTTON_BY_ID = "Xpath=//div[text()='%s']//parent::div/following-sibling::div//button/i[contains(@class,'bi-pencil-fill')]";
    public static final String DYNAMIC_EMPLOYEE_ID = "Xpath=//div[text()='%s']";
    public static final String CONFIRM_DELETE_BUTTON = "Xpath=//div[contains(@class,'orangehrm-dialog-popup')]//button[contains(string(),'Yes, Delete')]";
    public static final String EMPLOYEE_NAME_TEXTBOX = "Xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//input";
    public static final String SUB_UNIT_DROPDOWN_PARENT = "Xpath=//label[text()='Sub Unit']/parent::div/following-sibling::div//i";
    public static final String SUB_UNIT_DROPDOWN_CHILD = "Xpath=//label[text()='Sub Unit']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String SEARCH_BUTTON = "Xpath=//button[contains(normalize-space(.), 'Search')]";

}
