package com.zju.edu.controller;

import com.zju.edu.HBaseEntityManager;
import com.zju.edu.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@RestController
public class HBaseController {

    @Resource
    public HBaseEntityManager hBaseEM;

    @GetMapping(value = "/hello")
    public String hello(){
        User user = new User();
        //user.setUserId(1);
        user.setUserName("John");

        hBaseEM.getEntityManager().persist(user);
        return "hello, hbase";
    }
}
