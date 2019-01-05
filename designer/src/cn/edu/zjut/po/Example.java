package cn.edu.zjut.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Example {
	private Integer exampleId;
	private String name;
	private String description;
	private String style;
	private Integer praise=0;
	private Timestamp time;
	private String area;
	
	
	
	private Designer designer; //设计师
	private Set panoramas=new HashSet(0); //全景图
	private Set pictures=new HashSet(0);  //平面图
	private Set comments=new HashSet(0);  //评论
	private Set<Employer> em_collecters=new HashSet<Employer>();  //收藏
	public Example() {}
	public Example(Integer exampleId)
	{
		this.setExampleId(exampleId);
	}
	
	public Example(Integer exampleId, String name, String description, String style, Integer praise, Timestamp time,
			String area, Designer designer, Set panoramas, Set pictures, Set comments,
			Set<Employer> em_collecters) {
		super();
		this.exampleId = exampleId;
		this.name = name;
		this.description = description;
		this.style = style;
		this.praise = praise;
		this.time = time;
		this.area = area;
	
		this.designer = designer;
		this.panoramas = panoramas;
		this.pictures = pictures;
		this.comments = comments;
		this.em_collecters = em_collecters;
	}
	
	public Integer getExampleId() {
		return exampleId;
	}
	public void setExampleId(Integer exampleId) {
		this.exampleId = exampleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	public Set getPanoramas() {
		return panoramas;
	}
	public void setPanoramas(Set panoramas) {
		this.panoramas = panoramas;
	}
	public Set getPictures() {
		return pictures;
	}
	public void setPictures(Set pictures) {
		this.pictures = pictures;
	}
	public Set getComments() {
		return comments;
	}
	public void setComments(Set comments) {
		this.comments = comments;
	}
	public Set<Employer> getEm_collecters() {
		return em_collecters;
	}
	public void setEm_collecters(Set<Employer> em_collecters) {
		this.em_collecters = em_collecters;
	}
	
	
}
