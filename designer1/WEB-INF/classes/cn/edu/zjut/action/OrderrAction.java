package cn.edu.zjut.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.Comments;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.po.Orderr;
import cn.edu.zjut.service.IOrderrService;
import net.sf.json.JSONObject;

public class OrderrAction {
	private IOrderrService orderrServ=null;
	private String orderrId;
	private String state;
	private Orderr orderr;
	private Designer designer;
	private Employer employer;
	
	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public void setOrderrServ(IOrderrService orderrServ) {this.orderrServ=orderrServ;}
	public String getOrderrId(){return orderrId;}
	public void setOrderrId(String orderrId){this.orderrId=orderrId;}
	public Orderr getOrderr() {return orderr;}
	public void setOrderr(Orderr orderr) {this.orderr=orderr;}
	public String getState() {return state;}
	public void setState(String state) {this.state=state;}
	
	public String changeOrderrSt() throws Exception {
		if (orderrServ.changeOrderrSt(orderrId,state)) {
			return "success";
		} else {
			return "false";
		}
	}
	
	public String getOrderrByID() {
		System.out.println(orderrId);
		orderr= orderrServ.getOrderrByID(orderrId);
		return "success";
	}
	
	public String SubmitOrderr() {
		if (orderrServ.SubmitOrderr(orderr,designer,employer)) {
			return "success";
		} else {
			return "false";
		}
	}
}
