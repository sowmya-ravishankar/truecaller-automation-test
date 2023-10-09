package com.truecaller.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class ReadConfig {
    private Config config;
    private static ReadConfig readConfig;
    Logger LOGGER = LogManager.getLogger();

    public ReadConfig(String testTarget, Config config) {
        JSONObject configJson = null;
        String[] targetSplits = testTarget.split("\\.");

        String configFile = "configFile.json";

        try {
            configJson = new JSONObject(readConfigFile(configFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.config = config;
        LOGGER.info("Test configuration: " + testTarget);


        JSONObject execPlatformJson = configJson.getJSONObject(targetSplits[0]);
        JSONObject devicePlatformJson = execPlatformJson.getJSONObject(targetSplits[1]);
        config.setDevicePlatform(targetSplits[1]);

        JSONObject serverJson = devicePlatformJson.getJSONObject("server");
        AppiumServer server = new AppiumServer();

        server.setUrl(serverJson.getString("url"));

        server.setAutomationName(serverJson.getString("automationName"));
        server.setLaunchTimeout(serverJson.getInt("commandTimeout"));
        if (config.getDevicePlatform() == DevicePlatform.IOS) {
            server.setLaunchTimeout(serverJson.getInt("launchTimeout"));
        }

        config.setServer(server);

        JSONObject appJson = devicePlatformJson.getJSONObject("app");
        Map<String, String> app = new HashMap<>();

        if(config.getDevicePlatform() == DevicePlatform.ANDROID) {
            app.put(Config.ANDROID_APP_PACKAGE_KEY, appJson.getString(Config.ANDROID_APP_PACKAGE_KEY));
            app.put(Config.ANDROID_APP_ACTIVITY_KEY, appJson.getString(Config.ANDROID_APP_ACTIVITY_KEY));
        } else if(config.getDevicePlatform() == DevicePlatform.IOS) {
            app.put(Config.IOS_APP_BUNDLE_ID, appJson.getString(Config.IOS_APP_BUNDLE_ID));
        }

        config.setApp(app);

    }

    public Config getConfig() {
        return config;
    }

    private String readConfigFile(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();

        URL url = classLoader
                .getResource(fileName);

        File file = new File(url.getFile());

        return new String(Files.readAllBytes(file.toPath()));
    }
}
