package com.mm.pojo;

public class Teacher {
private int t_id;
private String t_name;
private int sub_id;
private String year,branch;
private int sem;
private String division;
public int getT_id() {
	return t_id;
}
public void setT_id(int t_id) {
	this.t_id = t_id;
}
public String getT_name() {
	return t_name;
}
public void setT_name(String t_name) {
	this.t_name = t_name;
}
public int getSub_id() {
	return sub_id;
}
public void setSub_id(int sub_id) {
	this.sub_id = sub_id;
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
public int getSem() {
	return sem;
}
public void setSem(int sem) {
	this.sem = sem;
}
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public Teacher(int t_id, String t_name, int sub_id, String year, String branch, int sem, String division) {
	super();
	this.t_id = t_id;
	this.t_name = t_name;
	this.sub_id = sub_id;
	this.year = year;
	this.branch = branch;
	this.sem = sem;
	this.division = division;
}
public Teacher(String t_name, int sub_id, String year, String branch, int sem, String division) {
	super();
	this.t_name = t_name;
	this.sub_id = sub_id;
	this.year = year;
	this.branch = branch;
	this.sem = sem;
	this.division = division;
}
public Teacher() {
	super();
	// TODO Auto-generated constructor stub
}



}
