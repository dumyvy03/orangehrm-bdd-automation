package com.orangehrm.pages.pageuis.pim;

public class EmployeeListPUI {
    public static final String ADD_EMPLOYEE_LINK = "Xpath=//a[text()='Add Employee']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_ID = "Xpath=//div[text()='%s']/parent::div/following-sibling::div//button/i[contains(@class,'bi-trash')]";
    public static final String DYNAMIC_EMPLOYEE_ID = "Xpath=//div[text()='%s']";
    public static final String CONFIRM_DELETE_BUTTON = "Xpath=//div[contains(@class,'orangehrm-dialog-popup')]//button[contains(string(),'Yes, Delete')]";
}
