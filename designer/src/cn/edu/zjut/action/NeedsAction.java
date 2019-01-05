package cn.edu.zjut.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONObject;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Needs;
import cn.edu.zjut.po.Orderr;
import cn.edu.zjut.service.INeedsService;
import javax.servlet.http.HttpServletResponse;

public class NeedsAction {
	Needs need;
	private INeedsService needsServ = null;

	public void setNeedsServ(INeedsService needsServ) {
		this.needsServ = needsServ;
	}

	public void setNeed(Needs need) {
		this.need = need;
	}

	public Needs getNeed() {
		return need;
	}

	public String order() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String message;
		if (needsServ.wanted(need)) {
			message = "鍙戝竷鎴愬姛!";
			request.setAttribute("tipMessage", message);
			return "success";
		}
		message = "鍙戝竷澶辫触!";
		request.setAttribute("tipMessage", message);
		return "fail";
	}


	private String city;
	private int area0;
	private int area1;
	private int money0;
	private int money1;
	private int order;
	private List needs1;
	private Needs needs;
	private int needsId;
	private Designer designer;
	private String designerId;
	private Orderr orderr;
	private List signupList;//我的接单申请列表
	public List getSignupList() {
		return signupList;
	}

	public void setSignupList(List signupList) {
		this.signupList =signupList;
	}
	public int getNeedsId() {
		return needsId;
	}

	public void setNeedsId(int needsId) {
		this.needsId = needsId;
	}
	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	public String getDesignerId() {
		return designerId;
	}
	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	public Needs getNeeds() {
		return needs;
	}

	public void setNeeds(Needs needs) {
		this.needs = needs;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getArea0() {
		return area0;
	}

	public void setArea0(int area0) {
		this.area0 = area0;
	}

	public int getArea1() {
		return area1;
	}

	public void setArea1(int area1) {
		this.area1 = area1;
	}

	public int getMoney0() {
		return money0;
	}

	public void setMoney0(int money0) {
		this.money0 = money0;
	}

	public int getMoney1() {
		return money1;
	}

	public void setMoney1(int money1) {
		this.money1 = money1;
	}

	public List getNeeds1() {
		return needs1;
	}

	public void setNeeds1(List needs1) {
		this.needs1 = needs1;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public Orderr getOrderr() {
		return orderr;
	}

	public void setOrderr(Orderr orderr) {
		this.orderr = orderr;
	}
	public String findneeds() {
		needs1 = needsServ.findneeds(city, area0, area1, money0, money1, order);
		return "findneedssuccess";
	}
	
	public String getNeedsByID() {
		needs = needsServ.getNeedsByID(needsId);
		return "success";
	}
	//设计师申请接单
	public void SignUp() throws Exception {
		JSONObject result = new JSONObject();
		if (needsServ.SignUp(needsId)) {
			result.put("success", true);
		} else {
			result.put("false", true);
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(result.toString());
		out.flush();
		out.close();
	}
	//通过接单申请挑选设计师后跳转创建订单页面
	public String SelectDes() throws Exception {
		if(needsServ.selectDes(needs,designer)) {
			return "success";
		}
		else return "false";
	}
}
