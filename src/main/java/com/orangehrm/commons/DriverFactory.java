package com.orangehrm.commons;

import com.orangehrm.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;

    private void initDriver(String browserName) {
        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        switch (browserType) {
            case CHROME:
                this.driver = new ChromeDriver();
                break;
            case EDGE:
                this.driver = new EdgeDriver();
                break;
            case FIREFOX:
                this.driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported");
        }
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
    }

    public WebDriver getDriver(String browserName) {
        if (this.driver == null) {
            initDriver(browserName);
        }
        return this.driver;
    }

    public void quitDriver() {
        if (this.driver != null) {
            this.driver.quit();
            this.driver = null;
        }
    }
}
