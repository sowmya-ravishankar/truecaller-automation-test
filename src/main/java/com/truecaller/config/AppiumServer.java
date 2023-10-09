package com.truecaller.config;

public class AppiumServer {

    private String url;
    private String automationName;
    private int launchTimeout;
    private int commandTimeout;

    public int getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public String getUrl() {
        return url;
    }

    public String getAutomationName() {
        return automationName;
    }

    public int getLaunchTimeout() {
        return launchTimeout;
    }

    public void setLaunchTimeout(int launchTimeout) {
        this.launchTimeout = launchTimeout;
    }

}
