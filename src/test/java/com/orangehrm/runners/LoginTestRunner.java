package com.orangehrm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = ("src/test/resources/features/login/Login.feature"),
        glue = {"com.orangehrm.steps",
                "com.orangehrm.hooks",
                "com.orangehrm.core"
        },
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
