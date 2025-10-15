package com.orangehrm.helper;

import com.orangehrm.commons.GlobalConstants;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.Properties;

public class AllureHelper {
    public static final Path REPORT = Paths.get("reports");
    public static final Path ALLURE_RESULTS = REPORT.resolve("allure-results");
    public static final Path ALLURE_REPORT = REPORT.resolve("allure-report");
    private static final String ENV_FILE_NAME = "environment.properties";
    private static final Path ENV_FILE = ALLURE_RESULTS.resolve(ENV_FILE_NAME);

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
                throw new RuntimeException(e);
            }
        }
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createEnvironmentFile() {
        try {
            Files.createDirectories(ENV_FILE.getParent());
            Properties prop = buildProperties();
            try (var outputStream = Files.newOutputStream(
                    ENV_FILE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING)) {
                prop.store(outputStream, "Allure Environment Properties");
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


    public static void bringHistory() {
        try {
            Path sourceHistory = ALLURE_REPORT.resolve("history");
            Path targetHistory = ALLURE_RESULTS.resolve("history");
            if (Files.exists(sourceHistory)) {
                Files.createDirectories(targetHistory);
                try (var stream = Files.walk(sourceHistory)) {
                    stream.forEach(p -> {
                        try {
                            Path target = targetHistory.resolve(sourceHistory.relativize(p));
                            if (Files.isDirectory(p)) Files.createDirectories(target);
                            else Files.copy(p, target, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            throw new RuntimeException(e.getMessage());
                        }
                    });
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
