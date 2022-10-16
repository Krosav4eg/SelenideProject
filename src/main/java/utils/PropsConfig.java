package utils;


import org.aeonbits.owner.Config;

/**
 * Following interface specifies the policy for loading the properties files.
 * By default the first available properties file specified by Config.Sources.
 */
@Config.Sources({"classpath:config.properties"})
public interface PropsConfig extends Config {

    @Config.Key("base.browser")
    String BASE_BROWSER();

    @Config.Key("base.url")
    String BASE_URL();

    @Config.Key("base.api.url")
    String BASE_API_URL();

    @Config.Key("waiting.timeout")
    String WAITING_TIMEOUT();

    @Config.Key("login")
    String LOGIN();

    @Config.Key("password")
    String PASSWORD();
}