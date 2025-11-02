package com.orangehrm.pages.pageuis.pim;

public class EmployeeListPUI {
    public static final String ADD_EMPLOYEE_LINK = "Xpath=//a[text()='Add Employee']";

    public static final String DELETE_BUTTON_BY_ID = "Xpath=//div[text()='%s']/parent::div/following-sibling::div//button/i[contains(@class,'bi-trash')]";

    public static final String EDIT_BUTTON = "Xpath=//button/i[contains(@class,'bi-pencil-fill')]";

    public static final String EMPLOYEE_ID_SEARCH_TEXTBOX = "Xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";

    public static final String EMPLOYEE_ID_IN_EMPLOYEE_TABLE = "Xpath=//div[text()='%s']";

    public static final String CONFIRM_DELETE_BUTTON = "Xpath=//div[contains(@class,'orangehrm-dialog-popup')]//button[contains(string(),'Yes, Delete')]";

    public static final String EMPLOYEE_NAME_TEXTBOX = "Xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//input";
    
    public static final String SEARCH_BUTTON = "Xpath=//button[contains(normalize-space(.), 'Search')]";

}
