package com.moreetech.ke.laundryussd.Configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author momondi  on 9/26/2021
 **/
@Configuration
@EnableRedisRepositories

// these keys will get two values for same key
//Redis config
public class RedisConfiguration extends CachingConfigurerSupport {

    @Value("${moreetech.cache.host}")
    private String host;

    @Value("${moreetech.cache.port}")
    private int port;

    @Value("${moreetech.cache.password}")
    private String password;

    @Value("${moreetech.cache.default-ttl}")
    private String defaultTTL;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(password);
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

}
