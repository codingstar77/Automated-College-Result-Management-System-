package com.mm.pojo;

/**
 * @author Kaustubh Devkar
 *
 */
public class Exam {
private int id;
private String exam_name,branch,year;
private int sem;
private String batch;
private int insem_max,endsem_max,prac_max,tw_max,oral_max;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getExam_name() {
	return exam_name;
}
public void setExam_name(String exam_name) {
	this.exam_name = exam_name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public int getSem() {
	return sem;
}
public void setSem(int sem) {
	this.sem = sem;
}
public String getBatch() {
	return batch;
}
public void setBatch(String batch) {
	this.batch = batch;
}
public int getInsem_max() {
	return insem_max;
}
public void setInsem_max(int insem_max) {
	this.insem_max = insem_max;
}
public int getEndsem_max() {
	return endsem_max;
}
public void setEndsem_max(int endsem_max) {
	this.endsem_max = endsem_max;
}
public int getPrac_max() {
	return prac_max;
}
public void setPrac_max(int prac_max) {
	this.prac_max = prac_max;
}
public int getTw_max() {
	return tw_max;
}
public void setTw_max(int tw_max) {
	this.tw_max = tw_max;
}
public int getOral_max() {
	return oral_max;
}
public void setOral_max(int oral_max) {
	this.oral_max = oral_max;
}
public Exam(int id, String exam_name, String branch, String year, int sem, String batch, int insem_max, int endsem_max,
		int prac_max, int tw_max, int oral_max) {
	super();
	this.id = id;
	this.exam_name = exam_name;
	this.branch = branch;
	this.year = year;
	this.sem = sem;
	this.batch = batch;
	this.insem_max = insem_max;
	this.endsem_max = endsem_max;
	this.prac_max = prac_max;
	this.tw_max = tw_max;
	this.oral_max = oral_max;
}
public Exam(String exam_name, String branch, String year, int sem, String batch, int insem_max, int endsem_max,
		int prac_max, int tw_max, int oral_max) {
	super();
	this.exam_name = exam_name;
	this.branch = branch;
	this.year = year;
	this.sem = sem;
	this.batch = batch;
	this.insem_max = insem_max;
	this.endsem_max = endsem_max;
	this.prac_max = prac_max;
	this.tw_max = tw_max;
	this.oral_max = oral_max;
}
public Exam() {
	super();
	// TODO Auto-generated constructor stub
}


}
