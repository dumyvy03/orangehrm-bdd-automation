package com.orangehrm.pages.login;

import com.orangehrm.core.BasePage;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.dashboard.DashboardPO;
import com.orangehrm.ui.login.LoginPUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePage {
    private final WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open Login page")
    public void openLoginPage() {
        driver.get("http://localhost:8080/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Step("Enter Username: {0}")
    private void enterUserNameTextbox(String username) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, LoginPUI.USERNAME_TEXTBOX, username);
    }

    @Step("Enter Password: {0}")
    private void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click Login button")
    public DashboardPO clickLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickElement(driver, LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }

    @Step("Enter username: {0} and password: {1} ")
    public void enterCredentials(String username, String password) {
        enterUserNameTextbox(username);
        enterPasswordTextbox(password);
    }

    @Step("Get login error message")
    public String getLoginErrorMessage() {
        waitForElementVisible(driver, LoginPUI.LOGIN_ERROR_MESSAGE);
        sleep(2);
        return getElementText(driver, LoginPUI.LOGIN_ERROR_MESSAGE);
    }

    @Step("Get username error message")
    public String getUsernameErrorMessage() {
        waitForElementVisible(driver, LoginPUI.USERNAME_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, LoginPUI.USERNAME_ERROR_MESSAGE);
    }

    @Step("Get password error message")
    public String getPasswordErrorMessage() {
        waitForElementVisible(driver, LoginPUI.PASSWORD_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, LoginPUI.PASSWORD_ERROR_MESSAGE);
    }
}
