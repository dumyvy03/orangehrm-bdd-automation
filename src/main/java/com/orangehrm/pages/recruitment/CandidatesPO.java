package com.orangehrm.pages.recruitment;

import com.orangehrm.core.BasePage;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.ui.recruitment.CandidatesPUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CandidatesPO extends BasePage {
    private WebDriver driver;

    public CandidatesPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Add button")
    public AddCandidatePO clickAddButton() {
        waitForElementVisible(driver, CandidatesPUI.ADD_CANDIDATES_BUTTON);
        scrollIntoViewJS(driver, CandidatesPUI.ADD_CANDIDATES_BUTTON);
        waitForElementClickable(driver, CandidatesPUI.ADD_CANDIDATES_BUTTON);
        sleep(1);
        clickElement(driver, CandidatesPUI.ADD_CANDIDATES_BUTTON);
        waitForLoadingIconInvisible(driver);
        return PageGenerator.getAddCandidatePage(driver);
    }
}
