package com.orangehrm.helper;

import com.orangehrm.context.TestContext;
import com.orangehrm.pages.pageobjects.pim.EmployeeListPO;
import com.orangehrm.pages.pageobjects.pim.PersonalDetailsPO;
import org.testng.Assert;

public class EmployeeCleanupHelper {
    private final TestContext testContext;

    public EmployeeCleanupHelper(TestContext testContext) {
        this.testContext = testContext;
    }

    public void cleanupTestEmployeeIfExists() {
        PersonalDetailsPO personalDetailsPage = testContext.getPageContext().getPersonalDetailsPage();
        String employeeId = (String) testContext.getScenarioContext().get("id");
        if (personalDetailsPage != null && employeeId != null && !employeeId.isEmpty()) {
            EmployeeListPO employeeListPage = personalDetailsPage.openPIMPage();
            employeeListPage.clickDeleteEmployeeButton(employeeId);
            employeeListPage.clickConfirmDeleteButton();
            Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeId));
        }
    }
}
