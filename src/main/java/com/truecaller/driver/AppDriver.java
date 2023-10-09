package com.truecaller.driver;

import com.truecaller.config.Config;
import com.truecaller.config.DevicePlatform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppDriver {

    private AppiumDriver<MobileElement> driver;
    private Config config;
    private URL url;
    private DesiredCapabilities desiredCapabilities;
    Logger LOGGER = LogManager.getLogger();

    public AppDriver() throws MalformedURLException {
        LOGGER.info("Setting capabilities");
        this.config = Config.getInstance();

        url = new URL(config.getServer().getUrl());

        desiredCapabilities = new DesiredCapabilities();

        initDriver();
    }

    public void initDriver() {
            setCapabilitiesForLocal();

            if (config.getDevicePlatform() == DevicePlatform.ANDROID) {
                setCapabilitiesForLocalAndroid();
                driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
            } else if (config.getDevicePlatform() == DevicePlatform.IOS) {
                setCapabilitiesForLocalIos();
                driver = new IOSDriver<MobileElement>(url, desiredCapabilities);
            }
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    private void setCapabilitiesForLocal() {
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getDeviceTarget().getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getDevicePlatform().toString());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getDeviceTarget().getPlatformVersion());
        desiredCapabilities.setCapability(MobileCapabilityType.APP, config.getApp().get(Config.APP_PATH));
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getServer().getAutomationName());
    }

    private void setCapabilitiesForLocalAndroid() {
        desiredCapabilities.setCapability(Config.ANDROID_APP_PACKAGE_KEY, config.getApp().get(Config.ANDROID_APP_PACKAGE_KEY));
        desiredCapabilities.setCapability(Config.ANDROID_APP_WAIT_ACTIVITY_KEY, config.getApp().get(Config.ANDROID_APP_WAIT_ACTIVITY_KEY));
        desiredCapabilities.setCapability(Config.ANDROID_APP_ACTIVITY_KEY, config.getApp().get(Config.ANDROID_APP_ACTIVITY_KEY));
    }

    private void setCapabilitiesForLocalIos() {
        desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, config.getApp().get(Config.IOS_APP_BUNDLE_ID));
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability("udid", "auto");
        desiredCapabilities.setCapability("xcodeSigningId", "");
        desiredCapabilities.setCapability("xcodeOrgId","");
    }
}
