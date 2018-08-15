package com.zju.edu;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@Component
public class HBaseEntityManager {

    @Resource
    @PersistenceUnit(unitName = "hbase_pu")
    public EntityManagerFactory hBaseEntityMF;

    public EntityManager getEntityManager(){
        return hBaseEntityMF.createEntityManager();
    }
}
