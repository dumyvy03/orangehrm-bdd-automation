package com.orangehrm.helper;

import com.orangehrm.commons.PageGenerator;
import com.orangehrm.context.ScenarioContext;
import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import org.testng.Assert;

public class EmployeeCleanupHelper {
    private final TestContext testContext;

    public EmployeeCleanupHelper(TestContext testContext) {
        this.testContext = testContext;
    }

    public void cleanupTestEmployeeIfExists() {
        ScenarioContext scenarioContext = testContext.getScenarioContext();
        scenarioContext.getOptional("employeeId").ifPresent(employeeId -> {
            EmployeeListPO employeeListPage = PageGenerator.getSidebarPage(testContext.getDriver()).openPIMPage();
            employeeListPage.clickDeleteEmployeeButton(employeeId.toString());
            employeeListPage.clickConfirmDeleteButton();
            Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeId.toString()));
        });
    }
}
