package com.mm.analysis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.mm.dao.ConnectionDAO;
import com.mm.pojo.Exam;
import com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord.Array;

class StudTop
{
	private int rank;
	private String uni_roll,stud_name,division;
	private int roll_no;
	private float sgpa;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public float getSgpa() {
		return sgpa;
	}
	public void setSgpa(float sgpa) {
		this.sgpa = sgpa;
	}
	public StudTop(int rank, String uni_roll, String stud_name, String division, int roll_no, float sgpa) {
		super();
		this.rank = rank;
		this.uni_roll = uni_roll;
		this.stud_name = stud_name;
		this.division = division;
		this.roll_no = roll_no;
		this.sgpa = sgpa;
	}
	
}
class SubResult
{
	private int sub_code;
	private String sub_name;
	private int total,pass,fail;
	private float pecentage;
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	public float getPecentage() {
		return pecentage;
	}
	public void setPecentage(float pecentage) {
		this.pecentage = pecentage;
	}
	public SubResult(int sub_code, String sub_name, int total, int pass, int fail, float pecentage) {
		super();
		this.sub_code = sub_code;
		this.sub_name = sub_name;
		this.total = total;
		this.pass = pass;
		this.fail = fail;
		this.pecentage = pecentage;
	}
	
}
class SubRank
{
	private int sub_code;
	private String sub_name,stu_id,stud_name;
	private int top;
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
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public SubRank(int sub_code, String sub_name, String stu_id, String stud_name, int top) {
		super();
		this.sub_code = sub_code;
		this.sub_name = sub_name;
		this.stu_id = stu_id;
		this.stud_name = stud_name;
		this.top = top;
	}
	
}
class ExamResult
{
	private int examid;
	private String exam_name;
	private int total,pass,fail;
	private float percentage;
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public ExamResult(int examid, String exam_name, int total, int pass, int fail, float percentage) {
		super();
		this.examid = examid;
		this.exam_name = exam_name;
		this.total = total;
		this.pass = pass;
		this.fail = fail;
		this.percentage = percentage;
	}
	
}
public class ExamWise {
	public static ArrayList<StudTop> getTopTen(int examid) throws SQLException
	{
		Statement st=ConnectionDAO.getStmt();
		ArrayList<StudTop> ar=new ArrayList<>();
		String sql="select p.uni_roll,p.stud_name,p.division,p.roll_no,s.sgpa from student p,sgpa_t s where"
				+ " s.exam_id="+examid+" and s.stu_id=p.uni_roll order by s.sgpa desc;";
		ResultSet rs=st.executeQuery(sql);
		float temp=0;
		int rank=0;
		while(rs.next())
		{
			if(rs.getFloat("sgpa")>temp)
				rank++;
			if(rs.getFloat("sgpa")>0)
				ar.add(new StudTop(rank,rs.getString("uni_roll"),rs.getString("stud_name"),rs.getString("division")
						, rs.getInt("roll_no"),rs.getFloat("sgpa")));
			
			temp=rs.getFloat("sgpa");
			
		}
			
		
		return ar;
		
		
	}
	public static ArrayList<SubRank> SubTop(int examid) throws SQLException
	{
		ArrayList<SubRank> ar=new ArrayList<>();
		String sql="select s.sub_code,s.sub_name,r.stu_id,k.stud_name,max(r.total) as top from subject s,result_t r,student k"
				+ " where r.exam_id="+examid+" and r.stu_id=k.uni_roll and s.sub_code=r.sub_code group by r.sub_code;";
		Statement st=ConnectionDAO.getStmt();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
			ar.add(new SubRank(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		
	return ar;
	
	}
	public static ArrayList<SubResult> getSubWise(int examid) throws SQLException
	{
		ArrayList<SubResult> ar=new ArrayList<>();
		String sql="select count(stu_id) from sgpa_t where exam_id="+examid+";";
		Statement st=ConnectionDAO.getStmt();
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		int total=rs.getInt(1);
		sql="select r.sub_code,s.sub_name,count(r.grade) from result_t r,subject s "
				+ " where r.grade='F' and exam_id="+examid+" and r.sub_code=s.sub_code group by sub_code;";
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			float perc=((total-rs.getInt(3))*100)/(float)total;
			ar.add(new SubResult(rs.getInt(1), rs.getString(2), total,total-rs.getInt(3),rs.getInt(3),perc));
		}
		return ar;
	}
	public static ExamResult getExamResult(int examid) throws SQLException
	{
		
		String sql="select count(stu_id) from sgpa_t where exam_id="+examid+";";
		Statement st=ConnectionDAO.getStmt();
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		int total=rs.getInt(1);
		sql="select count(stu_id) from sgpa_t where exam_id="+examid+" and sgpa>0";
		rs=st.executeQuery(sql);
		rs.next();
		int fail=rs.getInt(1);
		int pass=total-fail;
		float perc=(pass*100)/(float)total;
		sql="select exam_name from exam where id="+examid+";";
		rs=st.executeQuery(sql);
		rs.next();
		String exam_name=rs.getString(1);
		return new ExamResult(examid, exam_name, total, pass, fail, perc);
		
		
	}
}
