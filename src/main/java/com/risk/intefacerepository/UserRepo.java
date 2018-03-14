package com.risk.intefacerepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.risk.constraint.QuerySql;
import com.risk.producerpojo.PilotDesignation;
import com.risk.producerpojo.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	
	
	@Query(QuerySql.USERBYID)
	List<User> findByName(String userName,String password);

}