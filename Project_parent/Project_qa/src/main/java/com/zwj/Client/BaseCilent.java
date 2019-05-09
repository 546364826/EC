package com.zwj.Client;


import com.zwj.base.Result;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient("project-zwj")
public interface BaseCilent {

//    @RequestMapping(  method = RequestMethod.GET)
//    Result findAll();
//
    @RequestMapping(value="label/{id}",method =RequestMethod.GET)
    Result findLabelById(@PathVariable("id") String id);

//    @RequestMapping(value="label/{id}" ,method = RequestMethod.DELETE)
//    Result deleteLabelById(@PathVariable String id);
//
//
//    @GetMapping(value="label/findLabels" )
//     Result findLabels(@RequestBody Map searchMap);
//
//    @GetMapping(value="label/findLabels/{start}/{pageSize}" ) //select *from xxx where ...?
//    Result findLabels(@RequestBody Map searchMap, @PathVariable int start , @PathVariable int pageSize );

}
