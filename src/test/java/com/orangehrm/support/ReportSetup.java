package com.orangehrm.support;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ReportSetup {
    @BeforeSuite
    public void beforeTest() {
        ReportUtils.cleanResults();
        ReportUtils.bringHistory();
    }

    @AfterSuite
    public void afterTest() {
        ReportUtils.createEnvironmentFile();
    }
}
