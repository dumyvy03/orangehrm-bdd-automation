package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.pim.AddEmployeePUI;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class AddEmployeePO extends BasePage {
    private WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, AddEmployeePUI.EMPLOYEE_AVATAR);
    }

    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddEmployeePUI.FIRSTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, AddEmployeePUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddEmployeePUI.LASTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, AddEmployeePUI.LASTNAME_TEXTBOX, lastName);

    }

    public void uploadAvatar(String avatar) {
        sleep(1);
        handleFileUpload(driver, avatar);
    }

    public void enterEmployeeDetails(String firstName, String lastName, String avatar) {
        enterFirstNameTextbox(firstName);
        enterLastNameTextbox(lastName);
        uploadAvatar(avatar);
    }

    public PersonalDetailsPO clickSaveButton() {
        waitForElementClickable(driver, AddEmployeePUI.SAVE_BUTTON_ADD_EMPLOYEE);
        clickElement(driver, AddEmployeePUI.SAVE_BUTTON_ADD_EMPLOYEE);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public String getLastNameErrorMessage() {
        waitForElementVisible(driver, AddEmployeePUI.LASTNAME_ERROR_TEXT);
        return getElementText(driver, AddEmployeePUI.LASTNAME_ERROR_TEXT);
    }

    public String getAvatarErrorMessage() {
        waitForElementVisible(driver, AddEmployeePUI.AVATAR_ERROR_TEXTBOX);
        return getElementText(driver, AddEmployeePUI.AVATAR_ERROR_TEXTBOX);
    }

    public String getEmployeeIdValue() {
        waitForElementPresence(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX, "value");
    }
}
