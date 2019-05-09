package com.zwj.service;

import com.zwj.dao.CommentDao;
import com.zwj.entity.Comment;
import com.zwj.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Transactional(rollbackFor=Exception.class)
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    //redisTemplate ;
    @Autowired
    private MongoTemplate mongoTemplate ;

    @Autowired
    private IdWorker idWorker ;

    public List<Comment> findAll(){
        return commentDao.findAll() ;
    }

    public Comment findById(String id){
        return commentDao.findById(id).get() ;
    }

    public void addComment(Comment comment){//aaa 100

        comment.set_id(  String.valueOf( idWorker.nextId())  );
        if (comment.getParentId() != null) {
            Query query = new Query();
            Criteria criteria = Criteria.where("_id").is(comment.getParentId());
            query.addCriteria(criteria);
            Update update = new Update();
            update.inc("commentsCount",1);
            mongoTemplate.updateFirst(query, update, "comment");
        }
        commentDao.save(comment) ;
    }


    public void updateComment(Comment comment){
        commentDao.save(comment) ;
    }

    public void deleteCommentById(String id){
        commentDao.deleteById(id);
    }

    public Page<Comment> findByParentId( String parentId ,int start , int pageSize){
        PageRequest pageRequest = PageRequest.of(start - 1, pageSize);
        return commentDao.findByParentId(parentId   , pageRequest ) ;
    }

    public void updateLikes(String id){
        //以下会访问两次数据库
//        Comment comment = commentDao.findById(id).get();
//        comment.setLikes( comment.getLikes() +1  );
//        commentDao.save(comment) ;
        //update xxx set xx=xx+1 where ...  -->mongobd语句
        //通过mongobd语句 将数据库访问次数减为1次

        /*
                1query： where....
                2update
                3:集合（表）
         */
        Query query = new Query() ;
        //创建查询条件 ...where _id = ?
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria) ; //mybatis逆向工程类似

        Update update = new Update();
        update.inc("likes",1);//update comment set likes = likes+1 ;
        mongoTemplate.updateFirst( query,update,"comments" )   ;

    }


}
