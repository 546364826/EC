package com.zwj.client.impl;

import com.zwj.base.Result;
import com.zwj.base.StatusCode;
import com.zwj.client.UserClient;

import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {


    @Override
    public Result updateFans(String userId, int number) {
        System.out.println("熔断器启动了..........");
        return new Result(false, StatusCode.ERROR, "远程调用出现，启动熔断保护....");

    }
}
