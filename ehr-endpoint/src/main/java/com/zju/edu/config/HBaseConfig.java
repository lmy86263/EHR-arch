package com.zju.edu.config;

import com.zju.edu.hbase.HBaseBootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@Configuration
public class HBaseConfig {


    @Bean
    public HBaseBootstrap hBaseBootstrap(){

        return new HBaseBootstrap();
    }
}
