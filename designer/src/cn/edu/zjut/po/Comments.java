package cn.edu.zjut.po;

import java.sql.Timestamp;

public class Comments {
	private Integer commentsId;
	private String content;
	private Timestamp time;
	private Example example;
	private String reviewer; //评论者（设计师或雇主），不是外键

	public Comments() {}
	public Comments(Integer commentsId)
	{
		this.setCommentsId(commentsId);
	}
	public Comments(Integer commentsId,String content,String reviewer,Timestamp time,Example example)
	{
		this.setCommentsId(commentsId);
		this.setContent(content);
		this.setReviewer(reviewer);
		this.setTime(time);
		this.setExample(example);
	}
	public Integer getCommentsId() {
		return commentsId;
	}
	public void setCommentsId(Integer commentsId) {
		this.commentsId = commentsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Example getExample() {
		return example;
	}
	public void setExample(Example example) {
		this.example = example;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
}
