package com.orangehrm.runner.pim;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = ("src/test/resources/features/pim/SearchEmployee.feature"),
        glue = {"com.orangehrm.stepdefinitions",
                "com.orangehrm.hooks",
                "com.orangehrm.context",
                "com.orangehrm.commons"
        },
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)
public class SearchEmployeeTestRunner extends AbstractTestNGCucumberTests {
}


