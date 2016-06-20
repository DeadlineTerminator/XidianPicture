//这是一个javabean,对应users表，代表数据
//一个实例化对象，对应users表中的一条记录
package com.ghl.model;

public class UserBean {
	//表中的字段映射到类的成员，还是private的
	private String userid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String username;
	private String pswd;
	private String email;
}
