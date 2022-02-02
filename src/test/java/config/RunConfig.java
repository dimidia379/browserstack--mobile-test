package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:deviceHost.properties")
public interface RunConfig extends Config {

    @Key("deviceHost")
    @DefaultValue("browserstack")
    String deviceHost();
}