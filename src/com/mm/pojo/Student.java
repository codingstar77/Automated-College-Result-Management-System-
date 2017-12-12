package com.mm.pojo;

public class Student {
private int id;
private String prn;
private int roll_no;
private String uni_roll,stud_name,division,year,branch,batch,email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPrn() {
	return prn;
}
public void setPrn(String prn) {
	this.prn = prn;
}
public int getRoll_no() {
	return roll_no;
}
public void setRoll_no(int roll_no) {
	this.roll_no = roll_no;
}
public String getUni_roll() {
	return uni_roll;
}
public void setUni_roll(String uni_roll) {
	this.uni_roll = uni_roll;
}
public String getStud_name() {
	return stud_name;
}
public void setStud_name(String stud_name) {
	this.stud_name = stud_name;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getBatch() {
	return batch;
}
public void setBatch(String batch) {
	this.batch = batch;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Student(int id, String prn, int roll_no, String uni_roll, String stud_name, String division, String year,
		String branch, String batch, String email) {
	super();
	this.id = id;
	this.prn = prn;
	this.roll_no = roll_no;
	this.uni_roll = uni_roll;
	this.stud_name = stud_name;
	this.division = division;
	this.year = year;
	this.branch = branch;
	this.batch = batch;
	this.email = email;
}
public Student(String prn, int roll_no, String uni_roll, String stud_name, String division, String year, String branch,
		String batch, String email) {
	super();
	this.prn = prn;
	this.roll_no = roll_no;
	this.uni_roll = uni_roll;
	this.stud_name = stud_name;
	this.division = division;
	this.year = year;
	this.branch = branch;
	this.batch = batch;
	this.email = email;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}




}
