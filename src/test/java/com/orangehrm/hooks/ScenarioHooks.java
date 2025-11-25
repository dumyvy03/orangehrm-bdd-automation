package com.orangehrm.hooks;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.commons.PageGenerator;
import com.orangehrm.pages.pim.EmployeeListPO;
import com.orangehrm.stepdefinitions.pim.AddEmployeeSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
        try {
            if (AddEmployeeSteps.employeeId != null && AddEmployeeSteps.isEmployeeCreated) {
                String employeeId = AddEmployeeSteps.employeeId;
                EmployeeListPO employeeListPage = PageGenerator.getEmployeeListPage(DriverFactory.getDriver());
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
