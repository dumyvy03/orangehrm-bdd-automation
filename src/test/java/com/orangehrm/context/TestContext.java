package com.orangehrm.context;

import com.orangehrm.commons.DriverFactory;
import com.orangehrm.helper.EmployeeCleanupHelper;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter

public class TestContext {
    private final DriverFactory driverFactory;
    private WebDriver driver;
    private PageContext pageContext;
    private ScenarioContext scenarioContext;
    private EmployeeCleanupHelper employeeCleanupHelper;

    public TestContext(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
        pageContext = new PageContext();
        scenarioContext = new ScenarioContext();
    }

    public void init(String browserName) {
        driver = driverFactory.getDriver(browserName);
    }

    public void quit() {
        try {
            if (driverFactory != null) {
                driverFactory.quitDriver();
                driver = null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
