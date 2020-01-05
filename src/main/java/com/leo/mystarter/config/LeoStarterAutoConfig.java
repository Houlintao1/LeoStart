package com.leo.mystarter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * starter配置类
 *
 * @author hou
 * @date 2019-12-31 10:29 上午
 */
@Configuration
@ConditionalOnClass(LeoConfig.class)
public class LeoStarterAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    LeoConfig LeoStartConfig (){
        System.out.println("=== init ===");
        return new LeoConfig();
    }

}
