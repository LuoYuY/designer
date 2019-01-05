package cn.edu.zjut.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Needs {
	private Integer needsId;
	private String title;
	private String description;
	private String style;
	private Timestamp time1;
	private Timestamp time2;
	private Timestamp time3;
	private Float money;
	private Integer enrollment;
	private Employer employer;//雇主
	private Set designers=new HashSet(0);
	
	public Needs() {}
	public Needs(Integer needsId)
	{
		this.setNeedsId(needsId);
	}
	public Needs(Integer needsId,String title,String description,String style,Timestamp time1,Timestamp time2,
			Timestamp time3,Float money,Integer enrollment,Employer employer,Set designers)
	{
		this.setNeedsId(needsId);
		this.setTitle(title);
		this.setDescription(description);
		this.setStyle(style);
		this.setTime1(time1);
		this.setTime2(time2);
		this.setTime3(time3);
		this.setMoney(money);
		this.setEnrollment(enrollment);
		this.setEmployer(employer);
		this.setDesigners(designers);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Timestamp getTime1() {
		return time1;
	}
	public void setTime1(Timestamp time1) {
		this.time1 = time1;
	}
	public Timestamp getTime2() {
		return time2;
	}
	public void setTime2(Timestamp time2) {
		this.time2 = time2;
	}
	public Timestamp getTime3() {
		return time3;
	}
	public void setTime3(Timestamp time3) {
		this.time3 = time3;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public Integer getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Integer enrollment) {
		this.enrollment = enrollment;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Set getDesigners() {
		return designers;
	}
	public void setDesigners(Set designers) {
		this.designers = designers;
	}
	public Integer getNeedsId() {
		return needsId;
	}
	public void setNeedsId(Integer needsId) {
		this.needsId = needsId;
	}
}
