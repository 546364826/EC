package com.zwj.dao;


import com.zwj.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//DBUtil -> StudentDao  Class.forname    while(rs.next())
public interface AdminDao extends JpaRepository<Admin,String>, JpaSpecificationExecutor<Admin> {
    //根据名字找admin
    public Admin findByLoginname(String loginName) ;
}
