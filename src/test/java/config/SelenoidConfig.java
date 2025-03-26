package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:credentials.properties"
})

public interface SelenoidConfig extends Config {

    @Key("selenoidLogin")
    String username();

    @Key("selenoidPass")
    String password();
}
