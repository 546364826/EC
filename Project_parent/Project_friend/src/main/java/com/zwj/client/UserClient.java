package com.zwj.client;

import com.zwj.base.Result;
import com.zwj.client.impl.UserClientImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

//Friend调用User项目的接口
//@Component
@FeignClient(value="project-user" ,fallback = UserClientImpl.class)
public interface UserClient {
    @PutMapping("user/updateFans/{userId}/{number}")
    public Result updateFans(@PathVariable("userId") String userId, @PathVariable("number") int number) ;
}
