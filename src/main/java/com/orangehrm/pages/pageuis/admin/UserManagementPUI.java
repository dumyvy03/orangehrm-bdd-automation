package com.orangehrm.pages.pageuis.admin;

public class UserManagementPUI {
    public static final String ADD_BUTTON = "Xpath=//button[normalize-space(.)='Add']";

    public static final String USERNAME_IN_USER_TABLE = "Xpath=//div[text()='Username']/ancestor::div[@class='oxd-table-header']/following-sibling::div" +
            "//div[contains(@class,'oxd-table-cell')][2]/div[text()='%s']";

    public static final String USERNAME_SEARCH_TEXTBOX = "Xpath=//label[text()='Username']/parent::div/following-sibling::div/input";

    public static final String SEARCH_BUTTON = "Xpath=//button[normalize-space(.)='Search']";

    public static final String USERNAMES_IN_USER_TABLE = "Xpath=//div[text()='Username']/ancestor::div[@class='oxd-table-header']/following-sibling::div//div[contains(@class,'oxd-table-cell')][2]/div";

    public static final String DELETE_BUTTON = "Css=button>i.bi-trash";

    public static final String CONFIRM_DELETE_BUTTON = "Xpath=//div[contains(@class,'orangehrm-dialog-popup')]//button/i[contains(@class,'bi-trash')]";

    public static final String USER_CHECKBOX_BY_USERNAME = "Xpath=//div[text()='Username']/ancestor::div[@class='oxd-table-header']/following-sibling::div" +
            "//div[contains(@class,'oxd-table-cell')][2]/div[text()='%s']/parent::div/preceding-sibling::div//input";

    public static final String DELETE_SELECTED_BUTTON = "Xpath=//button[normalize-space(.)='Delete Selected']";

    public static String CONFIRM_CANCEL_BUTTON = "Xpath=//button[normalize-space(.)='No, Cancel']";
}
