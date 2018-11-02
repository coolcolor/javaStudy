package cn.cool.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanConfiguration {
    @Bean
    @Profile("dev")
    public Runnable test1() {
        System.out.print("我是开发环境");
        return () -> {
        };
    }

    @Bean
    @Profile("test")
    public Runnable test2() {
        System.out.print("我是测试环境");
        return () -> {
        };
    }

    @Bean
    @Profile("pro")
    public Runnable test3() {
        System.out.print("我是生产环境");
        return () -> {
        };
    }
}
