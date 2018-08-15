# EHR-arch

hbase orm映射框架：

1. [Kundera](https://github.com/Impetus/Kundera)
    已测试，支持hbase映射有问题，且最新版本3.13还未解决：java.lang.IllegalArgumentException: Can not set int field com.zju.edu.entity.User.userId to com.zju.edu.entity.User
    
2. [simplehbase](https://github.com/lmy86263/simplehbase)
    未测试，fork自alibaba，但是项目基本已死，最后一次更新是4年前，支持的hbase版本是0.94.0
    
3. [orm-hbase](https://github.com/lmy86263/orm-hbase)
    已测试，fork自zacharyzhanghao/orm-hbase，其中必须首先在hbase中建好表才能进行映射，无法实现类似hibernate式的自动映射，同时映射类型的处理存在问题，保存的数据放到数据库中会不一致
    比如，String类型的字段保存的时候会出现null，整型的字段全部保存为0