package com.moreetech.ke.laundryussd.Configs;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author momondi  on 9/26/2021
 **/
@Configuration
@ConfigurationProperties(prefix = "moreetech")
@Data
public class ApplicationConfiguration {

    private CacheConfigurationProperties cache;

    @Getter(value = AccessLevel.PUBLIC)
    private class CacheConfigurationProperties {
        private Integer port;
        private String host;
        private String password;
        private String defaultTtl;
    }
}
