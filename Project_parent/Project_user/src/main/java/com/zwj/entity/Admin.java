package com.zwj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_admin")
public class Admin implements Serializable {
    @Id
    private String id;
    private String username ;
    private String password;
    private String loginname;

    public Admin() {

    }
    public Admin(String username, String password, String loginname) {
        this.username = username;
        this.password = password;
        this.loginname = loginname;
    }

    public Admin(String id, String username, String password, String loginname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loginname = loginname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
}
