package com.mm.pojo;

public class Subject {
private int sub_id,sub_code;
private String sub_name,year,branch,batch;
private int sem;
public int getSub_id() {
	return sub_id;
}
public void setSub_id(int sub_id) {
	this.sub_id = sub_id;
}
public int getSub_code() {
	return sub_code;
}
public void setSub_code(int sub_code) {
	this.sub_code = sub_code;
}
public String getSub_name() {
	return sub_name;
}
public void setSub_name(String sub_name) {
	this.sub_name = sub_name;
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
public int getSem() {
	return sem;
}
public void setSem(int sem) {
	this.sem = sem;
}
public Subject(int sub_id, int sub_code, String sub_name, String year, String branch, String batch, int sem) {
	super();
	this.sub_id = sub_id;
	this.sub_code = sub_code;
	this.sub_name = sub_name;
	this.year = year;
	this.branch = branch;
	this.batch = batch;
	this.sem = sem;
}
public Subject(int sub_code, String sub_name, String year, String branch, String batch, int sem) {
	super();
	this.sub_code = sub_code;
	this.sub_name = sub_name;
	this.year = year;
	this.branch = branch;
	this.batch = batch;
	this.sem = sem;
}
public Subject() {
	super();
	// TODO Auto-generated constructor stub
}


}
