package com.zju.edu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.ClusterStatus;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;
import java.util.Map;

/**
 * @author lmy86263
 * @date 2018/08/10
 */
public class HbaseBootstrap {


    public static void main(String[] args) throws IOException {
        Configuration config = HBaseConfiguration.create();

        config.set("hbase.zookeeper.quorum", "172.16.119.173");

        Connection conn =  ConnectionFactory.createConnection(config);

        Admin admin = conn.getAdmin();

        ClusterStatus status = admin.getClusterStatus();
        System.out.println(status.getAverageLoad());


//        Table table = conn.getTable(TableName.valueOf("my_np:my_table"));
//
//        HTableDescriptor descriptor = table.getTableDescriptor();
//        Map<String, String> pairs = descriptor.getConfiguration();
//        pairs.keySet().stream().forEach(System.out::println);

    }

}
