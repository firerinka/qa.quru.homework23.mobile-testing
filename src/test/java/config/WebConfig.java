package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties",
        "classpath:config/mobile.properties",
        "file:~/${env}.properties",
        "file:./${env}.properties"
})
public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    Browser browser();

    @Key("browserVersion")
    @DefaultValue("106.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://www.jetbrains.com/ru-ru/")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("http://localhost:4444")
    String remoteUrl();

    @Key("videoStorage")
    String videoStorage();

    @Key("browserstack.userName")
    String browserstackUserName();

    @Key("browserstack.password")
    String browserstackPassword();

    @Key("browserstack.appUrl")
    String browserstackAppUrl();

    @Key("browserstack.device")
    String browserstackDevice();

    @Key("browserstack.os_version")
    String browserstackOsVersion();

    @Key("browserstack.project")
    String browserstackProject();

    @Key("browserstack.build")
    String browserstackBuild();

    @Key("browserstack.testsName")
    String browserstackTestsName();

    @Key("browserstack.remoteUrl")
    String browserstackRemoteUrl();

    @Key("browserstack.sessionsUrl")
    String browserstackSessionsUrl();
}
