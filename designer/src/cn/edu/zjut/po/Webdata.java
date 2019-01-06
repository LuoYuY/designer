package cn.edu.zjut.po;

import java.sql.Timestamp;

public class Webdata {
	private Integer dataid;
	private Integer visit;
	private Integer examplenum;
	private Integer designernum;
	private Integer employernum;
	private Integer ordernum;
	private Timestamp date;
	public Webdata() {
		super();
	}
	public Webdata(Integer dataid, Integer visit, Integer examplenum, Integer designernum, Integer employernum,
			Integer ordernum, Timestamp date) {
		super();
		this.dataid = dataid;
		this.visit = visit;
		this.examplenum = examplenum;
		this.designernum = designernum;
		this.employernum = employernum;
		this.ordernum = ordernum;
		this.date = date;
	}
	public Integer getDataid() {
		return dataid;
	}
	public void setDataid(Integer dataid) {
		this.dataid = dataid;
	}
	public Integer getVisit() {
		return visit;
	}
	public void setVisit(Integer visit) {
		this.visit = visit;
	}
	public Integer getExamplenum() {
		return examplenum;
	}
	public void setExamplenum(Integer examplenum) {
		this.examplenum = examplenum;
	}
	public Integer getDesignernum() {
		return designernum;
	}
	public void setDesignernum(Integer designernum) {
		this.designernum = designernum;
	}
	public Integer getEmployernum() {
		return employernum;
	}
	public void setEmployernum(Integer employernum) {
		this.employernum = employernum;
	}
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}
