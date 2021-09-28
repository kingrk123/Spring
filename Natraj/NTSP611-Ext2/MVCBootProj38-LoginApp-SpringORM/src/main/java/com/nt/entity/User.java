package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USERLIST")
@NamedQuery(name = "HQL_AUTH_QUERY",query = "SELECT COUNT(*) FROM User WHERE uname=:un AND pwd=:pass")
public class User  implements Serializable {
	@Id
	@Column(name="UNAME")
	private String user;
	private String pwd;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
