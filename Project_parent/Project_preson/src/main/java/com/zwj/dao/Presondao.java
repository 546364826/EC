package com.zwj.dao;

import com.zwj.entity.Preson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface Presondao extends JpaRepository<Preson,String>, JpaSpecificationExecutor<Preson> {

}
