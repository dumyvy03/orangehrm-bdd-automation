package com.orangehrm.hooks;

import com.orangehrm.context.ScenarioContext;
import com.orangehrm.context.TestContext;
import com.orangehrm.helper.AllureHelper;
import com.orangehrm.helper.EmployeeCleanupHelper;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @BeforeAll
    public static void cleanAllureResults() {
        AllureHelper.cleanResults();
        AllureHelper.bringHistory();
    }

    @AfterAll
    public static void createEnvFile() {
        AllureHelper.createEnvironmentFile();
    }

    @Before
    public void before() {
        XmlTest xmlTest = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
        String browserName = xmlTest.getParameter("browsers");
        if (browserName == null) {
            browserName = "chrome";
        }
        testContext.init(browserName);
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        WebDriver driver = testContext.getDriver();
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

    @After(order = 1)
    public void cleanupEmployee() {
        ScenarioContext context = testContext.getScenarioContext();
        boolean hasError = context.containsKey("errorMessage");
        if (!hasError) {
            new EmployeeCleanupHelper(testContext).cleanupTestEmployeeIfExists();
        }
        context.clearDataMap();
    }

    @After(order = 0)
    public void quitDriver() {
        testContext.quit();
    }
}
