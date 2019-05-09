package com.zwj.service;

import com.zwj.base.PageResult;
import com.zwj.dao.Presondao;
import com.zwj.entity.Preson;
import com.zwj.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresonService {
    @Autowired
    private Presondao presondao;
    @Autowired
    private IdWorker idWorker;
    //查询全部
    public List<Preson> findAll(){
        return presondao.findAll();
    }

    //根据id查询
    public Preson findPresonById(String id){
        return presondao.findById(id).get();
    }


    public Page findPresons(int Page, int PageSize) {

        PageRequest pageRequest = PageRequest.of(Page-1, PageSize);
        return presondao.findAll(pageRequest);
    }
    //添加数据
    public void savePreson(Preson preson) {
        preson.setId(idWorker.nextId()+"");
        presondao.save(preson);
    }

    //更新数据
    public void UpdatePreson(Preson preson) {
        presondao.save(preson);
    }

    //删除数据
    public void DelectPreson(String id) {
        presondao.deleteById(id);
    }

}
