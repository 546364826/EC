package com.zwj.dao;


import com.zwj.entity.Active;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ActiveDao extends JpaRepository<Active,String>, JpaSpecificationExecutor<Active> {
}