package com.frameworkium.bdd;

import com.frameworkium.core.common.properties.Property;
import com.frameworkium.core.ui.driver.drivers.ChromeImpl;
import com.google.common.collect.ImmutableMap;
import com.ten10.academy.practice.automation.config.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class CustomChromeImpl extends ChromeImpl {

    @Override
    public ChromeOptions getCapabilities() {
        ChromeOptions chromeOptions = super.getCapabilities();
        HashMap<String, Object> chromePrefs = new HashMap<>();

        // useful defaults
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + Config.getProperty("downloadPath"));
        chromeOptions.setCapability(
                "chrome.switches",
                "--no-default-browser-check");
        chromeOptions.setCapability(
                "chrome.prefs",
                ImmutableMap.of("profile.password_manager_enabled", "false"));
        chromeOptions.addArguments("--ignore-certificate-errors", "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.87 Safari/537.36");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        // Use Chrome's built in device emulators
        if (Property.DEVICE.isSpecified()) {
            chromeOptions.setExperimentalOption(
                    "mobileEmulation",
                    ImmutableMap.of("deviceName", Property.DEVICE.getValue()));
        }
        chromeOptions.setHeadless(Property.HEADLESS.getBoolean());
        return chromeOptions;
    }

    @Override
    public WebDriver getWebDriver(Capabilities capabilities) {
        return super.getWebDriver(capabilities);
    }
}
