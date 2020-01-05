package com.leo.mystarter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hou
 * @date 2019-12-31 10:38 上午
 */
@Configuration
public class LeoConfig {

    @Value("${leo.starter.name}")
    private String name;
    @Value("${leo.starter.desc}")
    private String desc;

    public String getDesc(){
        return name + desc;
    }

    @Bean
    public LeoConfig LeoMessiConfig(){
        return this;
    }

}
