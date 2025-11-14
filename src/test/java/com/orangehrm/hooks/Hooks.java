package com.orangehrm.hooks;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.stepdefinitions.pim.AddEmployeeSteps;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    private WebDriver driver;

    @Before
    public void before() {
        XmlTest xmlTest = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
        String browserName = xmlTest.getParameter("browsers");
        if (browserName == null) {
            browserName = "chrome";
        }
        DriverFactory.createDriver(browserName);
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        driver = DriverFactory.getDriver();
        if (scenario.isFailed() && driver != null) {
            try {
                String timestamp = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
                String screenshotName = "FailedStep_" + timestamp + ".png";
                byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(screenshotName, "image/png",
                        new ByteArrayInputStream(bytes), ".png");
                System.out.println("[Allure] Screenshot captured: " + screenshotName);
            } catch (Exception e) {
                System.out.println("[Allure] Cannot capture screenshot: " + e.getMessage());
            }
        }
    }

    @After
    public void after() {
        try {
            if (AddEmployeeSteps.employeeId != null && AddEmployeeSteps.isEmployeeCreated) {
                String employeeId = AddEmployeeSteps.employeeId;
                EmployeeListPO employeeListPage = PageGenerator.getSidebarPage(driver).openPIMPage();
                employeeListPage.clickDeleteEmployeeButton(employeeId);
                employeeListPage.clickConfirmDeleteButton();
                Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeId));
            }
        } finally {
            AddEmployeeSteps.employeeId = null;
            DriverFactory.quitDriver();
        }
    }
}
