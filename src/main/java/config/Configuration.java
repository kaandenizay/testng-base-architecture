package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({"classpath:configuration.properties"})
public interface Configuration extends Config {

//    @Key("browser")
    String browser();

}