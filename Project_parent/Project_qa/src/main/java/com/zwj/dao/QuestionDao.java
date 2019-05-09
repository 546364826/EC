package com.zwj.dao;


import com.zwj.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface QuestionDao extends JpaRepository<Question,String>, JpaSpecificationExecutor<Question> {
    //问题列表（分页）  JPQL：查询的是 “类名”，不是表
    @Query(value="select q from Question q where id in(select questionId from QuestionLabel where labelId = ?1 ) order by replyTime desc")
    public Page<Question> findNewQuestionsByLabelId(String labelId, Pageable pageable) ;

}
