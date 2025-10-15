package com.orangehrm.pages.pageobjects;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.commons.CommonPO;
import com.orangehrm.pages.pageobjects.dashboard.DashboardPO;
import com.orangehrm.pages.pageuis.LoginPUI;
import org.openqa.selenium.WebDriver;

public class LoginPO extends CommonPO {
    private final WebDriver driver;

    public LoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("http://localhost:8080/web/index.php/auth/login");
        driver.manage().window().maximize();
        sleep(2);
    }

    private void enterUserNameTextbox(String username) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendKeysElement(driver, LoginPUI.USERNAME_TEXTBOX, username);
        sleep(1);
    }

    private void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeysElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
        sleep(1);
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
        sleep(1);
        return getTextElement(driver, LoginPUI.LOGIN_ERROR_TEXT);
    }

}
