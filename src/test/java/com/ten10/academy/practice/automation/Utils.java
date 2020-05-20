package com.ten10.academy.practice.automation;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static void takeScreenshotAndSaveLocally(String testName, WebDriver driver) {
        String screenshotDirectory = System.getProperty("screenshotDirectory");
        if (screenshotDirectory == null) {
            screenshotDirectory = "screenshots";
        }
        String fileName = String.format(
                "%s_%s.png",
                System.currentTimeMillis(),
                testName);
        Path screenshotPath = Paths.get(screenshotDirectory);
        Path absolutePath = screenshotPath.resolve(fileName);
        if (createScreenshotDirectory(screenshotPath)) {
            writeScreenshotToFile(driver, absolutePath);
            //logger.info("Written screenshot to " + absolutePath);
        } else {
            //logger.error("Unable to create " + screenshotPath);
        }
    }

    private static boolean createScreenshotDirectory(Path screenshotDirectory) {
        try {
            Files.createDirectories(screenshotDirectory);
        } catch (IOException e) {
            //logger.error("Error creating screenshot directory", e);
        }
        return Files.isDirectory(screenshotDirectory);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] writeScreenshotToFile(WebDriver driver, Path screenshot) {
        try (OutputStream screenshotStream = Files.newOutputStream(screenshot)) {

            byte[] bytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            screenshotStream.write(bytes);
            screenshotStream.close();
            return bytes;
        } catch (IOException e) {
            //logger.error("Unable to write " + screenshot, e);
        } catch (WebDriverException e) {
            //logger.error("Unable to take screenshot.", e);
        }
        return null;
    }


}
