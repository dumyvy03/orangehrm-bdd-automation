package com.orangehrm.pages.pageobjects.login;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageuis.login.LoginPUI;
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
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, LoginPUI.USERNAME_TEXTBOX, username);

    }

    private void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
    }

    public DashboardPO clickLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickElement(driver, LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }

    public void enterCredentials(String username, String password) {
        enterUserNameTextbox(username);
        enterPasswordTextbox(password);
    }

    public String getLoginErrorMessage() {
        waitForElementVisible(driver, LoginPUI.LOGIN_ERROR_TEXT);
        sleep(2);
        return getElementText(driver, LoginPUI.LOGIN_ERROR_TEXT);
    }
}
