package com.zwj.service;


import com.zwj.dao.AdminDao;
import com.zwj.entity.Admin;
import com.zwj.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;


@Service
public class AdminService extends HttpServlet {
    @Autowired
    private AdminDao adminDao ;
    //添盐加密
    @Autowired
    private BCryptPasswordEncoder encoder ;

    @Autowired
    private IdWorker idWorker;

    //登陆：zs  abc  -> 张三账户
    public Admin findAdminByLoginNameAndPassword(String loginName ,String password){
        Admin admin = adminDao.findByLoginname(loginName);
        //admin.getPassword() 数据库中真实存在的 加密后的密码 ： abc  ->asdfsafsfasfdfasfsdf
        if(admin!=null &&  encoder.matches(password,admin.getPassword()) ){
            return admin ;
        }
        return null ;
    }
    public void addAdmin(Admin admin){ //1：id   2：密码  3：用户名等其他信息
        admin.setId( idWorker.nextId()+"" );
        //加密
        String encodePwd = encoder.encode(admin.getPassword());
        admin.setPassword(encodePwd);
        adminDao.save(admin) ;
    }

    public void deleteById(String id){
        adminDao.deleteById(id);
    }

}
