package com.zwj.controller;


import com.zwj.base.Result;
import com.zwj.base.StatusCode;
import com.zwj.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService ;
    @GetMapping(value = "popularList/{isPopular}" )
    public Result popularList(@PathVariable String isPopular){
        return new Result(true, StatusCode.OK,"查询成功",companyService.popularList(isPopular));
    }

    @GetMapping(value = "popularList" )
    public Result popularList(){
        return new Result(true, StatusCode.OK,"查询成功",companyService.popularList());
    }
}
