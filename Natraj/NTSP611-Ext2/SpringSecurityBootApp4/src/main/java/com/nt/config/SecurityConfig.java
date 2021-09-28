package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?").authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USERS_ROLES WHERE UNAME=?");
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home.htm").access("permitAll").antMatchers("/wish.htm").access("hasAnyRole('ROLE_MANAGEMENT','ROLE_EMPLOYEE')").and().formLogin().and().logout().logoutSuccessUrl("/logout_success.jsp").and().exceptionHandling().accessDeniedPage("/access_denied.jsp").and().rememberMe().and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}

}
