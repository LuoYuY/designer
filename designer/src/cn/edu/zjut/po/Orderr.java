package cn.edu.zjut.po;

import java.sql.Timestamp;

public class Orderr {
	private String orderrId;
	private String title;
	private String description;
	private Timestamp beginTime;
	private Timestamp designTime;
	private Timestamp finishTime;
	private Float money;
	private String state;
	private Employer employer;
	private Designer designer;
	
	public Orderr() {}
	public Orderr(String orderrId) 
	{
		this.setOrderrId(orderrId);
	}
	public Orderr(String orderrId, String title,String description, Timestamp beginTime, Timestamp designTime,Timestamp finishTime, Float money, String state,
			Employer employer, Designer designer) {
		super();
		this.orderrId = orderrId;
		this.title = title;
		this.description = description;
		this.beginTime = beginTime;
		this.designTime = designTime;
		this.finishTime = finishTime;
		this.money = money;
		this.state = state;
		this.employer = employer;
		this.designer = designer;
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
	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public Timestamp getDesignTime() {
		return designTime;
	}
	public void setDesignTime(Timestamp designTime) {
		this.designTime = designTime;
	}
	
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderrId() {
		return orderrId;
	}
	public void setOrderrId(String orderrId) {
		this.orderrId = orderrId;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
}
