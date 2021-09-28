package com.nt.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.User;


public interface UserRepo extends CrudRepository<User, String> {
	
	@Query(value = "select count(*) from User where user=:un and pwd=:pass")
     public   int  validate(@Param("un") String user,@Param("pass") String pwd);
}
