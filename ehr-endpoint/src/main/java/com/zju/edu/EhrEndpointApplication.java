package com.zju.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EhrEndpointApplication {

	public static void main(String[] args) {
	    SpringApplication app = new SpringApplication(EhrEndpointApplication.class);
	    app.addInitializers(new LifeCycleManager());
        app.run(args);
	}
}
