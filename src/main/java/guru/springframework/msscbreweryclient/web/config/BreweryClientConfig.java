package guru.springframework.msscbreweryclient.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreInvalidFields = true)
public abstract class BreweryClientConfig {

}
