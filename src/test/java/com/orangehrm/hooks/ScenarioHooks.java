package com.orangehrm.hooks;

import com.orangehrm.core.DriverFactory;
import com.orangehrm.core.PageGenerator;
import com.orangehrm.pages.pim.EmployeeListPO;
import com.orangehrm.steps.pim.AddEmployeeSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

public class ScenarioHooks {
    @Before(order = 0)
    public void before() {
        XmlTest xmlTest = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
        String browserName = (xmlTest != null)
                ? xmlTest.getParameter("browsers")
                : "chrome";
        DriverFactory.initDriver(browserName);
    }

    @After(order = 0)
    public void after() {
        WebDriver driver = DriverFactory.getDriver();
        try {
            boolean hasEmployee = AddEmployeeSteps.employeeId != null
                    && AddEmployeeSteps.isEmployeeCreated;
            if (hasEmployee) {
                String employeeId = AddEmployeeSteps.employeeId;
                EmployeeListPO employeeListPage = PageGenerator
                        .getPersonalDetailsPage(driver)
                        .clickEmployeeListLink(driver);
                employeeListPage.clickDeleteEmployeeButton(employeeId);
                employeeListPage.clickConfirmDeleteButton();
                Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeId));
            }

        } finally {
            AddEmployeeSteps.employeeId = null;
            AddEmployeeSteps.isEmployeeCreated = false;
            DriverFactory.quitDriver();
        }
    }

}
