package com.mm.pojo;

public class Admin {
private int id;
private String username,password,dept;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public Admin(int id, String username, String password, String dept) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.dept = dept;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(String username, String password, String dept) {
	super();
	this.username = username;
	this.password = password;
	this.dept = dept;
}

}
