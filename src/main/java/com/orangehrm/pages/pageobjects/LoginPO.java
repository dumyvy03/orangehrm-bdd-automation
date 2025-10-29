package com.orangehrm.pages.pageobjects;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageuis.LoginPUI;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePage {
    private final WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("http://localhost:8080/web/index.php/auth/login");
        driver.manage().window().maximize();
        sleep(2);
    }

    private void enterUserNameTextbox(String username) {
        sendKeysElement(driver, LoginPUI.USERNAME_TEXTBOX, username);
        sleep(1);
    }

    private void enterPasswordTextbox(String password) {
        sendKeysElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
        sleep(1);
    }

    public DashboardPO clickLoginButton() {
        clickElement(driver, LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }

    public void enterCredentials(String username, String password) {
        enterUserNameTextbox(username);
        enterPasswordTextbox(password);
    }

    public String getLoginErrorMessage() {
        return getTextElement(driver, LoginPUI.LOGIN_ERROR_TEXT);
    }

    public String getUsernameErrorMessage() {
        return getTextElement(driver, LoginPUI.USERNAME_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        return getTextElement(driver, LoginPUI.PASSWORD_ERROR_MESSAGE);
    }
}
