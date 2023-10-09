package com.truecaller.pom;

import com.truecaller.config.Config;
import com.truecaller.config.DevicePlatform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class POMBase {
    protected AppiumDriver driver;
    protected int waitTimeInSec = 20;
    protected DevicePlatform devicePlatform;
    static Logger LOGGER = LogManager.getLogger();

    public POMBase(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, AppiumFieldDecorator.DEFAULT_WAITING_TIMEOUT), this);

        try {
            devicePlatform = Config.getInstance().getDevicePlatform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
