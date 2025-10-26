package com.orangehrm.pages.pageobjects.pim;

import com.orangehrm.pages.pageuis.pim.ChangeProfilePicturePUI;
import org.openqa.selenium.WebDriver;

public class ChangeProfilePicturePO extends EmployeeNavigationPO {
    private WebDriver driver;

    public ChangeProfilePicturePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public PersonalDetailsPO uploadAvatar(String avatarPath) {
        handleFileUpload(driver, avatarPath);
        sleep(2);
        clickElement(driver, ChangeProfilePicturePUI.SAVE_PROFILE_PICTURE_BUTTON);
        waitForLoadingIconInvisible(driver);
        return openPersonalDetailsPage();
    }
}
