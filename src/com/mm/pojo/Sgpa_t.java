package com.mm.pojo;

public class Sgpa_t {
private int id;
private String stu_id;
private int exam_id;
private String batch;
private float sgpa;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStu_id() {
	return stu_id;
}
public void setStu_id(String stu_id) {
	this.stu_id = stu_id;
}
public int getExam_id() {
	return exam_id;
}
public void setExam_id(int exam_id) {
	this.exam_id = exam_id;
}
public String getBatch() {
	return batch;
}
public void setBatch(String batch) {
	this.batch = batch;
}
public float getSgpa() {
	return sgpa;
}
public void setSgpa(float sgpa) {
	this.sgpa = sgpa;
}
public Sgpa_t(int id, String stu_id, int exam_id, String batch, float sgpa) {
	super();
	this.id = id;
	this.stu_id = stu_id;
	this.exam_id = exam_id;
	this.batch = batch;
	this.sgpa = sgpa;
}
public Sgpa_t(String stu_id, int exam_id, String batch, float sgpa) {
	super();
	this.stu_id = stu_id;
	this.exam_id = exam_id;
	this.batch = batch;
	this.sgpa = sgpa;
}
public Sgpa_t() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Sgpa_t [id=" + id + ", stu_id=" + stu_id + ", exam_id=" + exam_id + ", batch=" + batch + ", sgpa=" + sgpa
			+ "]";
}

}
