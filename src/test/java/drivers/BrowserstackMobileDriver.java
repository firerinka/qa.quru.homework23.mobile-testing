package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ProjectConfiguration;
import config.WebConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @SneakyThrows
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        WebConfig config = ProjectConfiguration.webConfig;
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", config.browserstackUserName());
        mutableCapabilities.setCapability("browserstack.key", config.browserstackPassword());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", config.browserstackAppUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", config.browserstackDevice());
        mutableCapabilities.setCapability("os_version", config.browserstackOsVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", config.browserstackProject());
        mutableCapabilities.setCapability("build", config.browserstackBuild());
        mutableCapabilities.setCapability("name", config.browserstackTestsName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(new URL(config.browserstackRemoteUrl()), mutableCapabilities);
    }
}
