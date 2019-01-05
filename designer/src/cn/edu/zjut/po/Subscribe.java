package cn.edu.zjut.po;

import java.sql.Timestamp;

public class Subscribe {
	private int subscribeID;
	private String title;
	private String description;
	private Employer subscriber;
	private Designer scriber;
	private Float money;
	private Timestamp time;
	
	public Subscribe() {}
	
	public Subscribe(int subscriberID)
	{
		this.setSubscribeID(subscribeID);
	}
	public Subscribe(int subscriberID,String title,String description,Designer scriber,Employer subscriber,
			Float money,Timestamp time)
	{
		this.setSubscribeID(subscriberID);
		this.setTitle(title);
		this.setDescription(description);
		this.setSubscriber(subscriber);
		this.setScriber(scriber);
		this.setMoney(money);
		this.setTime(time);
	}
	
	public int getSubscribeID() {return subscribeID;}
	public void setSubscribeID(int subscribeID) {this.subscribeID = subscribeID;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public Designer getScriber() {return scriber;}
	public void setScriber(Designer scriber) {this.scriber = scriber;}
	public Employer getSubscriber() {return subscriber;}
	public void setSubscriber(Employer subscriber) {this.subscriber = subscriber;}
	public float getMoney() {return money;}
	public void setMoney(float money) {this.money = money;}
	public Timestamp getTime() {return time;}
	public void setTime(Timestamp time) {this.time = time;}
}
