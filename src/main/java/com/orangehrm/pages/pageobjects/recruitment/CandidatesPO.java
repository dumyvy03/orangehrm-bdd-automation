package com.orangehrm.pages.pageobjects.recruitment;

import com.orangehrm.commons.BasePage;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageuis.recruitment.CandidatesPUI;
import org.openqa.selenium.WebDriver;

public class CandidatesPO extends BasePage {
    private WebDriver driver;

    public CandidatesPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddCandidatePO clickAddButton() {
        scrollToElement(driver, CandidatesPUI.ADD_CANDIDATES_BUTTON);
        waitForElementClickable(driver, CandidatesPUI.ADD_CANDIDATES_BUTTON);
        clickElement(driver, CandidatesPUI.ADD_CANDIDATES_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getAddCandidatePage(driver);
    }
}
