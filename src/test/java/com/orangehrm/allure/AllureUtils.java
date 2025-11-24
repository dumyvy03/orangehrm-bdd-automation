package com.orangehrm.allure;

import com.orangehrm.commons.GlobalConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class AllureUtils {
    private static final Path REPORT_FOLDER = Paths.get("reports");
    private static final Path ALLURE_RESULTS = REPORT_FOLDER.resolve("allure-results");
    private static final String ENVIRONMENT_FILE_NAME = "environment.properties";
    private static final Path ENVIRONMENT_FILE = ALLURE_RESULTS.resolve(ENVIRONMENT_FILE_NAME);

    public static void cleanResults() {
        deleteDirectoryContents(ALLURE_RESULTS);
    }

    private static void deleteDirectoryContents(Path path) {
        try {
            Files.createDirectories(path);
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path entry : directoryStream) {
                    deleteRecursively(entry);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to clean directory: " + path, e);
        }
    }

    private static void deleteRecursively(Path path) {
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                for (Path child : stream) {
                    deleteRecursively(child);
                }
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to delete directory: " + path, e);
            }
        }
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to delete file: " + path, e);
        }
    }

    public static void createEnvironmentFile() {
        try {
            Files.createDirectories(ENVIRONMENT_FILE.getParent());
            Properties properties = buildProperties();
            try (var outputStream = Files.newOutputStream(
                    ENVIRONMENT_FILE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            )) {
                properties.store(outputStream, "Allure Environment Properties");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties buildProperties() {
        Properties prop = new Properties();
        prop.setProperty("OS", GlobalConstants.OS_NAME);
        prop.setProperty("Java.Version", GlobalConstants.JAVA_VERSION);
        prop.setProperty("Server", GlobalConstants.SERVER);
        prop.setProperty("ProjectName", GlobalConstants.PROJECT_NAME);
        return prop;
    }

    private static void attachScreenshot(String name, WebDriver driver) {
        if (driver == null) return;
        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
            String screenshotName = name + " " + timestamp + ".png";
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(screenshotName, "image/png",
                    new ByteArrayInputStream(bytes), ".png");
        } catch (Exception ex) {
            System.out.println("[ALLURE] Cannot attach screenshot: " + ex.getMessage());
        }
    }

    public static void attachFailureScreenshot(WebDriver driver) {
        attachScreenshot("Failed Step Screenshot", driver);
    }
}
