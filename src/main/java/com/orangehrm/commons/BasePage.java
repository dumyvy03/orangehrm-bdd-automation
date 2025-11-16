package com.orangehrm.commons;


import com.orangehrm.pages.pageuis.commons.BasePUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    /* ================================================
       1. LOCATORS
       ================================================= */

    private String formatLocator(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    private By getByLocator(String locatorExpression) {
        String[] locators = locatorExpression.split("=", 2);
        String locatorType = locators[0].trim().toLowerCase();
        String locatorValue = locators[1].trim();
        return switch (locatorType) {
            case "xpath" -> By.xpath(locatorValue);
            case "css" -> By.cssSelector(locatorValue);
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "classname" -> By.className(locatorValue);
            default -> throw new IllegalArgumentException("Invalid locator expression");
        };
    }

    public WebElement getElement(WebDriver driver, String locatorExpression) {
        return driver.findElement(getByLocator(locatorExpression));
    }


    public List<WebElement> getElements(WebDriver driver, String locatorExpression) {
        return driver.findElements(getByLocator(locatorExpression));
    }

    public List<WebElement> getElements(WebDriver driver, String locatorExpression, String... params) {
        return driver.findElements(getByLocator(formatLocator(locatorExpression, params)));
    }

    /* ================================================
      2. ELEMENT ACTIONS (click, type, select...)
      ================================================= */
    public void clickElement(WebDriver driver, String locatorExpression) {
        getElement(driver, locatorExpression).click();
    }

    public void clickElement(WebDriver driver, String locatorExpression, String... params) {
        getElement(driver, formatLocator(locatorExpression, params)).click();
    }

    public void clearTextbox(WebDriver driver, String locator) {
        getElement(driver, locator).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public void sendKeysElement(WebDriver driver, String locatorExpression, String value) {
        getElement(driver, locatorExpression).sendKeys(value);
    }

    public void selectDropdownCustomer(WebDriver driver, String parentLocatorExpression, String childLocatorExpression, String value) {
        getElement(driver, parentLocatorExpression).click();
        List<WebElement> elements = getElements(driver, childLocatorExpression);
        for (WebElement element : elements) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    public void scrollToElement(WebDriver driver, String locatorExpression) {
        new Actions(driver).scrollToElement(getElement(driver, locatorExpression)).perform();
    }

    public void scrollToElement(WebDriver driver, String locatorExpression, String... params) {
        new Actions(driver).scrollToElement(getElement(driver, formatLocator(locatorExpression, params))).perform();
    }

    public void selectDropdownSuggestion(WebDriver driver, String locatorExpression, String value) {
        List<WebElement> elements = getElements(driver, locatorExpression);
        for (WebElement element : elements) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    /* ================================================
       3. GETTERS (text, attribute, size, css, etc.)
       ================================================= */
    public String getAttributeValue(WebDriver driver, String locatorExpression, String attributeName) {
        return getElement(driver, locatorExpression).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locatorExpression) {
        return getElement(driver, locatorExpression).getText();
    }

    public List<String> getElementsText(WebDriver driver, String locatorExpression) {
        return getElements(driver, locatorExpression)
                .stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());
    }

    public Dimension getElementSize(WebDriver driver, String locatorExpression) {
        return getElement(driver, locatorExpression).getSize();
    }

    /* ================================================
        4. ELEMENT STATE CHECKERS
        ================================================= */
    public boolean isElementUnDisplayed(WebDriver driver, String locatorExpression, String... params) {
        overrideImplicitTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getElements(driver, locatorExpression, params);
        overrideImplicitTimeout(driver, GlobalConstants.LONG_TIMEOUT);
        if (elements.isEmpty()) {
            return true;
        }
        return elements.stream().noneMatch(webElement -> {
            try {
                return webElement.isDisplayed();
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                return false;
            }
        });
    }

    public boolean isElementDisplayed(WebDriver driver, String locatorExpression, String... params) {
        return getElement(driver, formatLocator(locatorExpression, params)).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locatorExpression, String... params) {
        return getElement(driver, formatLocator(locatorExpression, params)).isSelected();
    }

    /* ================================================
        5. JAVASCRIPT UTILITIES
        ================================================= */
    public void checkElementByJS(WebDriver driver, String locatorExpression, String... params) {
        WebElement element = getElement(driver, formatLocator(locatorExpression, params));
        if (!element.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    getElement(driver, formatLocator(locatorExpression, params)));
        }
    }

    /* ================================================
      6. WAIT HANDLERS
      ================================================= */
    public void waitForElementVisible(WebDriver driver, String locatorExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorExpression)));
    }

    public void waitForElementVisible(WebDriver driver, String locatorExpression, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(formatLocator(locatorExpression, params))));
    }

    public void waitListForElementsVisible(WebDriver driver, String locatorExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locatorExpression)));
    }


    public void waitForElementPresence(WebDriver driver, String locatorExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locatorExpression)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locatorExpression)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorExpression, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(formatLocator(locatorExpression, params))));
    }


    public void waitForElementInVisible(WebDriver driver, String locatorExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorExpression)));
    }

    public void waitForElementInVisible(WebDriver driver, String locatorExpression, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(formatLocator(locatorExpression, params))));
    }

    public void waitForElementSelected(WebDriver driver, String locatorExpression, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(formatLocator(locatorExpression, params))));
    }

    public void waitForLoadingIconInvisible(WebDriver driver) {
        waitForElementInVisible(driver, BasePUI.LOADING_ICON);
    }


    /* ================================================
        8. TIME METHODS
        ================================================= */
    private void overrideImplicitTimeout(WebDriver driver, long timeoutSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutSeconds));
    }

    public void sleep(long timeoutSeconds) {
        try {
            Thread.sleep(timeoutSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /* ================================================
        9. FILE HANDLING
        ================================================= */
    public void handleFileUpload(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        StringBuilder allFilePaths = new StringBuilder();
        for (String fileName : fileNames) {
            allFilePaths.append(filePath).append(fileName).append("\n");
        }
        String combinedFilePaths = allFilePaths.toString().trim();
        waitForElementPresence(driver, BasePUI.UPLOAD_FILE_TYPE);
        getElement(driver, BasePUI.UPLOAD_FILE_TYPE).sendKeys(combinedFilePaths);
    }
}
