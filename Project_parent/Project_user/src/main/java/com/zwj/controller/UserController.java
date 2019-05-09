package com.zwj.controller;


import com.zwj.base.Result;
import com.zwj.base.StatusCode;
import com.zwj.entity.User;
import com.zwj.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("endSms/{phone}")
    public Result sendSms(@PathVariable String phone) {
        userService.sendSms(phone);
        return new Result(true, StatusCode.OK, "短信发送成功");
    }

    @PostMapping("register/{smsCode}")
    public Result register(@RequestBody User user, @PathVariable String smsCode) {
        userService.addUser(user, smsCode);
        return new Result(true, StatusCode.OK, "注册成功");
    }

    //删除：先判断token(Authrorization)
    @DeleteMapping("{id}")
    public Result delete(@PathVariable String id) {
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "权限不足！");
        }
        userService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功！");
    }

    @PutMapping("updateFans/{userId}/{number}")
    public Result updateFans(@PathVariable("userId") String userId, @PathVariable("number") int number) {
        userService.updateFansCount(userId, number);
        System.out.println("===============================");
//        System.out.println(1/0);
        return new Result(true, StatusCode.OK, "粉丝更新成功！");

    }
}
