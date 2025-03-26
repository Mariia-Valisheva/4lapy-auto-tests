package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:credentials.properties"
})

public interface CredentialsConfig extends Config {

    @Key("lapyEmail")
    String lapyEmail();

    @Key("lapyPass")
    String lapyPass();
}
