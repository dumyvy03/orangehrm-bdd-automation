package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.pages.pageobjects.commons.SidebarPO;
import com.orangehrm.pages.pageuis.pim.AddEmployeePUI;
import com.orangehrm.pages.pageuis.pim.PersonalDetailsPUI;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPO extends SidebarPO {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getFirstNameTextbox() {
        return getAttributeValue(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getMiddleNameTextbox() {
        return getAttributeValue(driver, PersonalDetailsPUI.MIDDLE_TEXTBOX, "value");
    }

    public String getLastNameTextbox() {
        return getAttributeValue(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, "value");
    }

    public boolean isAvatarUploadSuccess(Dimension avatarBeforeSize) {
        Dimension avatarAfterUploadSize = getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_AVATAR);
        return !avatarAfterUploadSize.equals(avatarBeforeSize);
    }

    public String getEmployeeIdAtDetailsPage() {
        return getAttributeValue(driver, AddEmployeePUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

}
