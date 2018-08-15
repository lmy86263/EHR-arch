package com.zju.edu.controller;

import com.zju.edu.entity.Person;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zachary.zhanghao.columnar.exception.ColumnarClientException;
import zachary.zhanghao.columnar.hbase.HBaseColumnarClient;

import javax.annotation.Resource;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@RestController
public class HBaseController {

//    @Resource
//    public HBaseEntityManager hBaseEM;

    @Resource
    public HBaseColumnarClient client;

    @GetMapping(value = "/hello")
    public String hello(){
//        User user = new User();
//        user.setUserId(1);
//        user.setUserName("John");
//
//        hBaseEM.getEntityManager().persist(user);
        return "hello, hbase";
    }

    @GetMapping(value = "/orm")
    public String orm() throws ColumnarClientException {
        Person person = new Person();
        person.setAge(34);
        person.setId(2);
        person.setUserId(123);
        person.setUserName("Kitty");
        client.putObject(person);

        return "hello, orm";
    }

    @GetMapping(value = "/getOrm")
    public String ormGetter() throws ColumnarClientException {
        Person person = client.findObject(Bytes.toBytes(2), Person.class);

        System.out.println(person);

        return person.toString();
    }

}
