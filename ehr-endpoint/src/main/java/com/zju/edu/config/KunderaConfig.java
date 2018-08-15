package com.zju.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@Configuration
public class KunderaConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){

        LocalContainerEntityManagerFactoryBean entityMF = new LocalContainerEntityManagerFactoryBean();

        entityMF.setPersistenceUnitName("hbase_pu");
        entityMF.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

        

        return entityMF;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor(){
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    public DefaultPersistenceUnitManager defaultPersistenceUnitManager(){
        DefaultPersistenceUnitManager persistenceUM = new DefaultPersistenceUnitManager();
        persistenceUM.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");

        return persistenceUM;
    }

}
