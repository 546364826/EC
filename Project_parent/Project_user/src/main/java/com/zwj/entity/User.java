package com.zwj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tb_user")
public class User implements Serializable {
    @Id
    private String id;
    private String username ;
    private String phone ;
    private String password;
    private int fans ;//粉丝数
    private Date registerTime ;
    private Date updateTime ;
    private Date lastLoginTime ;
    public User() {
    }

    public User(String id, String username, String phone,String password,int fans, Date registerTime, Date updateTime, Date lastLoginTime) {
        this.id = id;
        this.username = username;
        this.fans = fans;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;
    }
    public User(String username,  String phone,String password, int fans, Date registerTime, Date updateTime, Date lastLoginTime) {
        this.username = username;
        this.fans = fans;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
