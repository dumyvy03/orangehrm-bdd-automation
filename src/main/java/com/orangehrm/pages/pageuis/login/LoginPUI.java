package com.orangehrm.pages.pageuis.login;

public class LoginPUI {
    public static final String USERNAME_TEXTBOX = "Name=username";
    public static final String PASSWORD_TEXTBOX = "Name=password";
    public static final String LOGIN_BUTTON = "Css=button.orangehrm-login-button";
    public static final String LOGIN_ERROR_TEXT = "Xpath=//div[@class='orangehrm-login-error']//p";
    public static final String USERNAME_ERROR_MESSAGE = "Xpath=//label[text()='Username']/parent::div//following-sibling::span[text()='Required']";
    public static final String PASSWORD_ERROR_MESSAGE = "Xpath=//label[text()='Password']/parent::div//following-sibling::span[text()='Required']";
}

