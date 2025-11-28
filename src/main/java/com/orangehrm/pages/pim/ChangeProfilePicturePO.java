package com.orangehrm.pages.pim;

import com.orangehrm.ui.pim.ChangeProfilePicturePUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ChangeProfilePicturePO extends EmployeeNavigationPO {
    private WebDriver driver;

    public ChangeProfilePicturePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Upload Avatar")
    public void uploadAvatar(String avatarPath) {
        handleFileUpload(driver, avatarPath);
        waitForElementClickable(driver, ChangeProfilePicturePUI.SAVE_PROFILE_PICTURE_BUTTON);
        sleep(1);
        clickElement(driver, ChangeProfilePicturePUI.SAVE_PROFILE_PICTURE_BUTTON);
        waitForLoadingIconInvisible(driver);
    }
}
