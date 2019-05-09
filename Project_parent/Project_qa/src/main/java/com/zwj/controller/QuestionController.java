package com.zwj.controller;

import com.zwj.Client.BaseCilent;
import com.zwj.entity.Question;

import com.zwj.service.QuestionService;
import com.zwj.base.Result;
import com.zwj.base.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService ;

//    @Resource
    @Autowired
    private BaseCilent baseCilent;

    @GetMapping(value="quesionlist/{labeid}/{start}/{pagesize}")
    public Result findNewQuestionsByLabelId(@PathVariable String labeid, @PathVariable int start, @PathVariable int pagesize){
        Page<Question> quesionsPage = questionService.findNewQuestionsByLabelId(labeid, start, pagesize);
        return new Result(true, StatusCode.OK,"查询成功",quesionsPage  );
    }


    @RequestMapping(value = "findLabelById/{labeid}",method = RequestMethod.GET)
    public Result findLabelById(@PathVariable String labeid) {
        return   baseCilent.findLabelById(labeid);
    }

}
