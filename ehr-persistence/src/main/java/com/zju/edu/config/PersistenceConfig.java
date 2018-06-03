package com.zju.edu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author lmy86263
 * @date 2018/06/03
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PersistenceConfig {

    private Environment env;

    @Autowired
    public PersistenceConfig(Environment env){
        this.env = env;
    }

    @Bean(name="cdrDataSource")
    public DataSource cdrDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(env.getProperty("cdr.driverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(env.getProperty("cdr.url"));
        dataSource.setUser(env.getProperty("cdr.username"));
        dataSource.setPassword(env.getProperty("cdr.password"));

        // connection pool
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxPoolSize(20);
        dataSource.setAcquireIncrement(5);

        return dataSource;
    }

}
