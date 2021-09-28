package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.nt.entity.User;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public long validate(User user) {
		List<?> list=null;
		//execute named Query with name param
		list= ht.findByNamedQueryAndNamedParam("HQL_AUTH_QUERY",
				                                                                             new String[] {"un","pass"},
				                                                                             new String[] {user.getUser(),user.getPwd()});
		
		return (long)list.get(0);
	}

}
