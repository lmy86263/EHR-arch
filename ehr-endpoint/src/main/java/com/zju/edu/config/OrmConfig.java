package com.zju.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zachary.zhanghao.columnar.config.DataSourceConfig;
import zachary.zhanghao.columnar.exception.ColumnarClientException;
import zachary.zhanghao.columnar.hbase.HBaseColumnarClient;
import zachary.zhanghao.columnar.hbase.HBaseSource;

/**
 * @author lmy86263
 * @date 2018/08/15
 */
@Configuration
public class OrmConfig {


    @Bean
    public HBaseColumnarClient hBaseColumnarClient() throws ColumnarClientException {
        HBaseColumnarClient client = new HBaseColumnarClient();

        DataSourceConfig config = new DataSourceConfig("hbase.properties");
        HBaseSource source = new HBaseSource(config.getProperties());

        client.setHBaseSource(source);
        return client;
    }
}
