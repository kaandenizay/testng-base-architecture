package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigurationManager {

    private ConfigurationManager() {
    }

    public static Configuration configuration() {
        return ConfigFactory.create(Configuration.class);
    }

}

