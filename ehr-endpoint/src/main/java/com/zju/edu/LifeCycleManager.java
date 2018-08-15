package com.zju.edu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@Slf4j
public class LifeCycleManager implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if(System.getProperty("os.name").contains("Windows")){
            System.setProperty("hadoop.home.dir", "C:\\Users\\lmy86263\\3D Objects\\hadoop-common-2.2.0-bin-master\\hadoop-common-2.2.0-bin-master");
        }
    }
}
