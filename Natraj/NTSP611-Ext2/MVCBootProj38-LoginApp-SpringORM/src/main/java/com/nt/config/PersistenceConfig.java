package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.User;

@Configuration
//@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	@Autowired
	private  DataSource ds;
	
	@Bean(name="sesfact",autowire = Autowire.BY_TYPE)
	public  LocalSessionFactoryBean  createLSFB() {
		LocalSessionFactoryBean sesfact=null;
		sesfact=new LocalSessionFactoryBean();
		//sesfact.setDataSource(ds);
		sesfact.setAnnotatedClasses(User.class);
		sesfact.setAnnotatedPackages("com.nt.entity");
		return sesfact;
	}
	
	@Bean(name="template",autowire = Autowire.BY_TYPE)
	public  HibernateTemplate createHT() {
	    //return new HibernateTemplate(createLSFB().getObject());
		return  new HibernateTemplate();
	}

}
