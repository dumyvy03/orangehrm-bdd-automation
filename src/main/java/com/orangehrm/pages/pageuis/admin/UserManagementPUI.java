package com.orangehrm.pages.pageuis.admin;

public class UserManagementPUI {
    public static final String ADD_BUTTON = "Xpath=//button[normalize-space(.)='Add']";

    public static final String USERNAME_IN_USER_TABLE = "Xpath=//div[text()='Username']/ancestor::div[@class='oxd-table-header']/following-sibling::div" +
            "//div[contains(@class,'oxd-table-cell')][2]/div[text()='%s']";
}
