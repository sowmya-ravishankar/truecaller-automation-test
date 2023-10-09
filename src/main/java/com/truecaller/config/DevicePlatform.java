package com.truecaller.config;

public enum DevicePlatform {
    ANDROID("Android"),
    IOS("iOS"),
    INVALID("Invalid");

    private String devicePlatform;

    DevicePlatform(String devicePlatform) {
        this.devicePlatform = devicePlatform;
    }

    public String toString() {
        return devicePlatform;
    }
}
