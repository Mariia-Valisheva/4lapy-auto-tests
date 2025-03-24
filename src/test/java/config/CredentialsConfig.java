package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:credentials.properties",
        "system:env"
})

public interface CredentialsConfig extends Config {

    @Key("lapyEmail")
    String lapyEmail();

    @Key("lapyPass")
    String lapyPass();
}
