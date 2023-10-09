package com.truecaller.test;

import com.truecaller.config.Config;
import com.truecaller.config.DevicePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestBase {
    private AppiumDriverLocalService server;
    Config config;
    DevicePlatform devicePlatform;
    protected static Logger LOGGER = LogManager.getLogger();

    @BeforeSuite
    @Parameters({"target"})
    public void setUpAppium(String target) {
        config = Config.getInstance(target);
        devicePlatform = config.getDevicePlatform();

        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingPort(4723);

        LOGGER.info("Starting Appium server...");
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();

    }


    @AfterSuite
    public void teardownAppium() {
        LOGGER.info("Stopping Appium server...");
        server.stop();
    }
}
