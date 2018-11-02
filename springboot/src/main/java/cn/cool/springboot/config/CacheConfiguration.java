package cn.cool.springboot.config;

import cn.cool.springboot.controller.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {
    @Bean
    public Cache createCacheObj() {
        return new Cache();
    }
}
