package com.orangehrm.runner.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = ("src/test/resources/features/login/Login.feature"),
        glue = {"com.orangehrm.stepdefinitions",
                "com.orangehrm.hooks",
                "com.orangehrm.context",
                "com.orangehrm.commons"
        },
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}


