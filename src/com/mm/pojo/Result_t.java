package com.mm.pojo;

public class Result_t {
	private int id,sub_id,exam_id;
	private String stu_id;
	private int insem,endsem,total,practical,term_work,oral;
	private String grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public int getInsem() {
		return insem;
	}
	public void setInsem(int insem) {
		this.insem = insem;
	}
	public int getEndsem() {
		return endsem;
	}
	public void setEndsem(int endsem) {
		this.endsem = endsem;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPractical() {
		return practical;
	}
	public void setPractical(int practical) {
		this.practical = practical;
	}
	public int getTerm_work() {
		return term_work;
	}
	public void setTerm_work(int term_work) {
		this.term_work = term_work;
	}
	public int getOral() {
		return oral;
	}
	public void setOral(int oral) {
		this.oral = oral;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Result_t(int id, int sub_id, int exam_id, String stu_id, int insem, int endsem, int total, int practical,
			int term_work, int oral, String grade) {
		super();
		this.id = id;
		this.sub_id = sub_id;
		this.exam_id = exam_id;
		this.stu_id = stu_id;
		this.insem = insem;
		this.endsem = endsem;
		this.total = total;
		this.practical = practical;
		this.term_work = term_work;
		this.oral = oral;
		this.grade = grade;
	}
	public Result_t(int sub_id, int exam_id, String stu_id, int insem, int endsem, int total, int practical,
			int term_work, int oral, String grade) {
		super();
		this.sub_id = sub_id;
		this.exam_id = exam_id;
		this.stu_id = stu_id;
		this.insem = insem;
		this.endsem = endsem;
		this.total = total;
		this.practical = practical;
		this.term_work = term_work;
		this.oral = oral;
		this.grade = grade;
	}
	public Result_t() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Result_t [id=" + id + ", sub_id=" + sub_id + ", exam_id=" + exam_id + ", stu_id=" + stu_id + ", insem="
				+ insem + ", endsem=" + endsem + ", total=" + total + ", practical=" + practical + ", term_work="
				+ term_work + ", oral=" + oral + ", grade=" + grade + "]";
	}
	
}
