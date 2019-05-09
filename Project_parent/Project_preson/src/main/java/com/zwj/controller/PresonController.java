package com.zwj.controller;

import com.zwj.base.PageResult;
import com.zwj.base.Result;
import com.zwj.base.StatusCode;
import com.zwj.entity.Preson;
import com.zwj.service.PresonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Preson")
public class PresonController {
    @Autowired
    private PresonService presonService;

    //查询全部
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK,"查询成功",
                presonService.findAll() );
    }
    //根据id查询
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public Result findPresonById(@PathVariable("id") String id){
        return new Result(true,StatusCode.OK,"查询成功", presonService.findPresonById(id) ) ;
    }

    @GetMapping("{Page}/{PageSize}")
    public Result findPresons(@PathVariable int Page, @PathVariable int PageSize) {
        Page pages = presonService.findPresons(Page, PageSize);
        long TotalElements = pages.getTotalElements();
        List<Preson> content = pages.getContent();
        PageResult pageResult = new PageResult(TotalElements, content);
        return new Result(true, StatusCode.OK, "查询成功",pageResult );
    }

    //更新
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result UpdatePreson(@RequestBody Preson preson, @PathVariable("id") String id) {
        preson.setId(id);
        presonService.UpdatePreson(preson);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    //删除
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result DelectPreson(@PathVariable("id") String id) {
        presonService.DelectPreson(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //添加
    @RequestMapping(method = RequestMethod.POST)
//    @PostMapping
    public Result saveLabel(@RequestBody Preson preson){
        presonService.savePreson(preson);
        return new Result(true,StatusCode.OK,"增加成功" ) ;//alt + 回车  / alt+insert
    }
}
