package com.nt.command;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class UserCommand {
	@NotBlank(message = "user is mandatory")
	@Length(message = "user must have min of 4 chars and max of 10 chars",
	                  min = 4,max = 10)
	private  String user;
	@NotBlank(message = "pwd is mandatory")
	@Length(message = "pwd must have min of 4 chars",min = 4)
	private String pwd;
	private  Date  doj;
	
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
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "UserCommand [user=" + user + ", pwd=" + pwd + ", doj=" + doj + "]";
	}


	
	
}
