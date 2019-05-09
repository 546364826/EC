package com.zwj.service;

import com.zwj.dao.RecruitDao;
import com.zwj.entity.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {
    @Autowired
    private RecruitDao recruitDao ;

    public List<Recruit> findTop10ByStateOrderByPublishTime(String state){
        return recruitDao.findTop10ByStateOrderByPublishTimeDesc(state);
    }
}
