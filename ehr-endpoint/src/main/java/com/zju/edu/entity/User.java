package com.zju.edu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lmy86263
 * @date 2018/08/14
 */
@Entity
@Table(name = "users")
//@Getter
//@Setter
//@NoArgsConstructor
public class User
{
    public User(){}

    @Id
    @Column(name = "rowkey")
    private int userId;

    @Column(name = "PERSON_NAME")
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
