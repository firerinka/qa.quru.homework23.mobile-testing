package config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {
    public static final WebConfig webConfig = ConfigReader.Instance.read();

    public static void apiConfig() {
        RestAssured.baseURI = webConfig.baseUrl();
    }

    public static void webConfig() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser().toString();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.remoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    public static String getVideoStorageUrl() {
        return webConfig.videoStorage();
    }

    public static Boolean isRemote() {
        return webConfig.isRemote();
    }
}
