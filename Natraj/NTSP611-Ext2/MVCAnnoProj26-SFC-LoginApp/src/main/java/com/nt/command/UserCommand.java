package com.nt.command;



public class UserCommand {
	private  String user;
	private String pwd;
	private String[] hobies=new String[] {"singing"};
	private String[] domains=new String[] {"gmail"};
	private  String country="china";
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
	public String[] getHobies() {
		return hobies;
	}
	public void setHobies(String[] hobies) {
		this.hobies = hobies;
	}
	public String[] getDomains() {
		return domains;
	}
	public void setDomains(String[] domains) {
		this.domains = domains;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	/*public UserCommand() {
		System.out.println("UserCommand :: 0-param constructor");
	}*/

}
