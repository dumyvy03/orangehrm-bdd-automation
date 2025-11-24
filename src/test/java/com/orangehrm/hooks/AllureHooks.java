package com.orangehrm.hooks;

import com.orangehrm.allure.AllureUtils;
import com.orangehrm.commons.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;

public class AllureHooks {

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        Allure.step("Start scenario: " + scenario.getName());
    }

    @After(order = 1)
    public void captureFailureScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getDriver();
            AllureUtils.attachFailureScreenshot(driver);
        }
    }
}
