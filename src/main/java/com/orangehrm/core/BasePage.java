package com.orangehrm.core;


import com.orangehrm.ui.common.CommonPUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    private String formatLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    private By getByLocator(String locator) {
        String[] locators = locator.split("=", 2);
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

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }


    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator, String... params) {
        return driver.findElements(getByLocator(formatLocator(locator, params)));
    }

    public void clickElement(WebDriver driver, String locatorExpression) {
        getElement(driver, locatorExpression).click();
    }

    public void clickElement(WebDriver driver, String locator, String... params) {
        getElement(driver, formatLocator(locator, params)).click();
    }

    public void clearTextbox(WebDriver driver, String locator) {
        getElement(driver, locator).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public void sendKeysElement(WebDriver driver, String locator, String value) {
        getElement(driver, locator).sendKeys(value);
    }

    public void selectDropdownCustomer(WebDriver driver, String parentLocator, String childLocator, String value) {
        getElement(driver, parentLocator).click();
        List<WebElement> elements = getElements(driver, childLocator);
        for (WebElement element : elements) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    public void selectDropdownSuggestion(WebDriver driver, String locator, String value) {
        List<WebElement> elements = getElements(driver, locator);
        for (WebElement element : elements) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public List<String> getElementsText(WebDriver driver, String locator) {
        return getElements(driver, locator)
                .stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());
    }

    public Dimension getElementSize(WebDriver driver, String locator) {
        return getElement(driver, locator).getSize();
    }

    public boolean isElementUnDisplayed(WebDriver driver, String locator, String... params) {
        List<WebElement> elements = getElements(driver, locator, params);
        return elements.isEmpty();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
        return getElement(driver, formatLocator(locator, params)).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... params) {
        return getElement(driver, formatLocator(locator, params)).isSelected();
    }


    public void checkElementByJS(WebDriver driver, String locator, String... params) {
        WebElement element = getElement(driver, formatLocator(locator, params));
        if (!element.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    getElement(driver, formatLocator(locator, params)));
        }
    }

    public void scrollIntoViewJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                getElement(driver, locator));
    }

    public void scrollIntoViewJS(WebDriver driver, String locator, String... params) {
        WebElement element = getElement(driver, formatLocator(locator, params));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});",
                element
        );
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(formatLocator(locator, params))));
    }

    public void waitListForElementsVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(formatLocator(locator, params))));
    }
    
    public void waitForElementSelected(WebDriver driver, String locator, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(formatLocator(locator, params))));
    }

    public void waitForLoadingIconInvisible(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(CommonPUI.LOADING_ICON)));
    }

    public void sleep(long timeoutSeconds) {
        try {
            Thread.sleep(timeoutSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleFileUpload(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        StringBuilder allFilePaths = new StringBuilder();
        for (String fileName : fileNames) {
            allFilePaths.append(filePath).append(fileName).append("\n");
        }
        String combinedFilePaths = allFilePaths.toString().trim();
        getElement(driver, CommonPUI.UPLOAD_FILE_TYPE).sendKeys(combinedFilePaths);
    }
}
