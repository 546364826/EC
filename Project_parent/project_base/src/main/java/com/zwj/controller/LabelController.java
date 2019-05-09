package com.zwj.controller;

import com.zwj.base.PageResult;
import com.zwj.base.Result;
import com.zwj.base.StatusCode;
import com.zwj.entity.Label;
import com.zwj.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController    //可以return值直接打印
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;


    @RequestMapping(  method = RequestMethod.GET)
    public Result findAll(){
//        System.out.println(1/0);
        return new Result(true, StatusCode.OK,"查询成功",
                labelService.findAll() );
    }

    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public   Result findLabelById(@PathVariable("id") String id){
        return new Result(true,StatusCode.OK,"查询成功", labelService.findLabelById(id) ) ;
    }

    //json->对象
    @RequestMapping(method = RequestMethod.POST)
//    @PostMapping
    public Result saveLabel(@RequestBody Label label){
        labelService.saveLabel(label);
        return new Result(true,StatusCode.OK,"增加成功" ) ;//alt + 回车  / alt+insert
    }
    //label: 1  hello ....
    //label: 1  world ....
    @RequestMapping(value="{id}" ,method = RequestMethod.PUT)
    public Result updateLabel(@RequestBody Label label ,@PathVariable("id")String id){//UPDATE ..WHERE ID =?
        label.setId(id);
        labelService.updateLabel(label);
        return new Result(true,StatusCode.OK,"修改成功" ) ;
    }

    @RequestMapping(value="{id}" ,method = RequestMethod.DELETE)
    public Result deleteLabelById(@PathVariable String id){

        labelService.deleteLabelById(id);
        return new Result(true,StatusCode.OK,"删除成功" ) ;
    }

    /*

        RequestBody: json->对象
                     json->map
     */
    @GetMapping(value="findLabels" )
    public Result findLabels(@RequestBody Map searchMap){//labelname:旅游  recommend:1
        return new Result(true,StatusCode.OK,"查询成功" , labelService.findLabels(searchMap)) ;
    }

    @GetMapping(value="findLabels/{start}/{pageSize}" ) //select *from xxx where ...?
    public Result findLabels(@RequestBody Map searchMap,@PathVariable int start , @PathVariable int pageSize ){
        Page labelsPage = labelService.findLabels(searchMap, start, pageSize);

        long totalSize = labelsPage.getTotalElements();//总数据量
        List<Label> labels = labelsPage.getContent();//每页的数据
        PageResult pageResult = new PageResult(totalSize, labels);
        return new Result(true,StatusCode.OK,"查询成功" , pageResult ) ;
    }



}
