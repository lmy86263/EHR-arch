package com.zju.edu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.ClusterStatus;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author lmy86263
 * @date 2018/08/10
 */
public class HBaseBootstrap {




    public static void main(String[] args) throws IOException {

        if(System.getProperty("os.name").contains("Windows")){
            System.setProperty("hadoop.home.dir", "C:\\Users\\lmy86263\\3D Objects\\hadoop-common-2.2.0-bin-master\\hadoop-common-2.2.0-bin-master");
        }

        Configuration config = HBaseConfiguration.create();
//
        config.set("hbase.zookeeper.quorum", "172.16.119.208");

//        Admin admin = new HBaseAdmin(config);


        System.out.println("here..................");

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
