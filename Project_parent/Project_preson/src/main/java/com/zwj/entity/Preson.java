package com.zwj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tb_preson")
public class Preson implements Serializable {
        @Id
        private String id;
        private String name;//姓名
        private String sex;//性别 1： 男 0：女
        private String degree;//学位
        private String hands;//工作经验
        private String phone;//电话
        private String email;//邮箱
        private String idea;//想法
        private String headpic;//头像

    public Preson() {

    }
//    public Preson(String name, String sex, String degree, String hands, String phone, String email, String idea, String headpic) {
//
//        this.name = name;
//        this.sex = sex;
//        this.degree = degree;
//        this.hands = hands;
//        this.phone = phone;
//        this.email = email;
//        this.idea = idea;
//        this.headpic = headpic;
//    }
    public Preson(String id, String name, String sex, String degree, String hands, String phone, String email, String idea, String headpic) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.degree = degree;
        this.hands = hands;
        this.phone = phone;
        this.email = email;
        this.idea = idea;
        this.headpic = headpic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getHands() {
        return hands;
    }

    public void setHands(String hands) {
        this.hands = hands;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }
}
