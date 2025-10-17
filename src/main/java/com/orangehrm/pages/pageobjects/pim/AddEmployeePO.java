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

    private void enterFirstNameTextbox(String firstName) {
        sendKeysElement(driver, AddEmployeePUI.FIRSTNAME_TEXTBOX, firstName);
        sleep(1);
    }

    private void enterLastNameTextbox(String lastName) {
        sendKeysElement(driver, AddEmployeePUI.LASTNAME_TEXTBOX, lastName);
        sleep(1);
    }

    private void uploadAvatar(String avatar) {

        handleFileUpload(driver, avatar);
        sleep(1);
    }

    public void enterEmployeeDetails(String firstName, String lastName, String avatar) {
        enterFirstNameTextbox(firstName);
        enterLastNameTextbox(lastName);
        uploadAvatar(avatar);
    }

    public PersonalDetailsPO clickSaveButton() {
        clickElement(driver, AddEmployeePUI.SAVE_BUTTON_ADD_EMPLOYEE);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public String getEmployeeIdTextbox() {
        return getAttributeValue(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX, "value");
    }
}
