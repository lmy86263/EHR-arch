package com.zju.edu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import zachary.zhanghao.columnar.annotation.Column;
import zachary.zhanghao.columnar.annotation.RowKey;
import zachary.zhanghao.columnar.annotation.Table;

/**
 * @author lmy86263
 * @date 2018/08/15
 */
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Person {

    @RowKey
    private int id;

    @Column(family = "info")
    private int userId;

    @Column(family = "info", name = "user_name")
    private String userName;

    @Column(family = "info")
    private long age;
}
