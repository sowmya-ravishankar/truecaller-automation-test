package com.truecaller.config;

import java.util.Map;

public class Config {

    public static final String ANDROID_APP_PACKAGE_KEY = "appPackage";
    public static final String ANDROID_APP_ACTIVITY_KEY = "appActivity";
    public static final String ANDROID_APP_WAIT_ACTIVITY_KEY = "appWaitActivity";
    public static final String APP_PATH = "path";

    public static final String IOS_APP_BUNDLE_ID = "bundleId";

    private Map<String, String> app;
    private DeviceTarget deviceTargets;
    private AppiumServer server;
    private DevicePlatform devicePlatform;
    private Map<String, String> project;
    private static Config config;

    private Config() {}


    public static Config getInstance() {
        return config;
    }
    public static Config getInstance(String target) {
        if(config == null) {
            config = new Config();
        }

        return config;
    }

    public void setApp(Map<String, String> app) {
        this.app = app;
    }

    public void setDeviceTarget(DeviceTarget deviceTargets) {
        this.deviceTargets = deviceTargets;
    }


    public void setServer(AppiumServer server) {
        this.server = server;
    }

    public void setDevicePlatform(String devicePlatform) {
        if(devicePlatform.toLowerCase().compareTo("android") == 0)
            this.devicePlatform = DevicePlatform.ANDROID;
        else if(devicePlatform.toLowerCase().compareTo("ios") == 0)
            this.devicePlatform = DevicePlatform.IOS;
        else
            this.devicePlatform = DevicePlatform.INVALID;
    }

    public void setProject(Map<String, String> project) {
        this.project = project;
    }

    public Map<String, String> getProject() {
        return project;
    }

    public Map<String, String> getApp() {
        return app;
    }

    public DeviceTarget getDeviceTarget() {
        return deviceTargets;
    }

    public AppiumServer getServer() {
        return server;
    }

    public DevicePlatform getDevicePlatform() {
        return devicePlatform;
    }

}
