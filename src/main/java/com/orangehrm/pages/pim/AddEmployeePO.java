package com.orangehrm.pages.pim;

import com.orangehrm.core.BasePage;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.ui.pim.AddEmployeePUI;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class AddEmployeePO extends BasePage {
    private WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public Dimension getAvatarSize() {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOYEE_AVATAR);
        return getElementSize(driver, AddEmployeePUI.EMPLOYEE_AVATAR);
    }

    @Step("Enter First Name: {0}")
    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddEmployeePUI.FIRSTNAME_TEXTBOX);
        sendKeysElement(driver, AddEmployeePUI.FIRSTNAME_TEXTBOX, firstName);
        sleep(1);
    }

    @Step("Enter Last Name: {0}")
    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddEmployeePUI.LASTNAME_TEXTBOX);
        sendKeysElement(driver, AddEmployeePUI.LASTNAME_TEXTBOX, lastName);
        sleep(1);
    }

    @Step("Upload Avatar: {0}")
    public void uploadAvatar(String avatar) {
        handleFileUpload(driver, avatar);
        sleep(1);
    }

    @Step("Enter employee details")
    public void enterEmployeeDetails(String firstName, String lastName) {
        enterFirstNameTextbox(firstName);
        enterLastNameTextbox(lastName);
    }

    @Step("Click Save button")
    public PersonalDetailsPO clickSaveButton() {
        waitForElementClickable(driver, AddEmployeePUI.SAVE_BUTTON_ADD_EMPLOYEE);
        clickElement(driver, AddEmployeePUI.SAVE_BUTTON_ADD_EMPLOYEE);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    @Step("Get first name error message")
    public String getFirstNameErrorMessage() {
        waitForElementVisible(driver, AddEmployeePUI.FIRSTNAME_ERROR_MESSAGE);
        return getElementText(driver, AddEmployeePUI.FIRSTNAME_ERROR_MESSAGE);
    }

    @Step("Get last name error message")
    public String getLastNameErrorMessage() {
        waitForElementVisible(driver, AddEmployeePUI.LASTNAME_ERROR_MESSAGE);
        return getElementText(driver, AddEmployeePUI.LASTNAME_ERROR_MESSAGE);
    }

    @Step("Get avatar error message")
    public String getAvatarErrorMessage() {
        waitForElementVisible(driver, AddEmployeePUI.AVATAR_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, AddEmployeePUI.AVATAR_ERROR_MESSAGE);
    }

    @Step("Get generated employee ID value")
    public String getEmployeeIdValue() {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

}
