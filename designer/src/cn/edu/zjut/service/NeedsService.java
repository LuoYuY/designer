package cn.edu.zjut.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.dao.INeedsDAO;
import cn.edu.zjut.dao.IOrderrDAO;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Needs;
import cn.edu.zjut.po.Orderr;

public class NeedsService implements INeedsService {
	private Map<String, Object> request, session;
	private INeedsDAO needsDAO = null;
	private IDesignerDAO designerDAO = null;
	private IOrderrDAO orderrDAO = null;
	private IEmployerDAO employerDAO = null;// 鍒版椂鍊欏垹鎺�

	private List needs1 = new ArrayList();

	public void setNeedsDAO(INeedsDAO needsDAO) {
		this.needsDAO = needsDAO;
	}
	public void setDesignerDAO(IDesignerDAO designerDAO) {
		this.designerDAO = designerDAO;
	}
	public void setOrderrDAO(IOrderrDAO orderrDAO) {
		this.orderrDAO =orderrDAO;
	}

	public void setEmployerDAO(IEmployerDAO employerDAO) {
		this.employerDAO = employerDAO;
	}

	public boolean wanted(Needs need) {
		ActionContext ctx = ActionContext.getContext();
		session = (Map) ctx.getSession();
		request = (Map) ctx.get("request");
		int id = needsDAO.find();
		need.setNeedsId(id + 1);
		Employer user =(Employer)session.get("employer");
		need.setEmployer(user);
		need.setEnrollment(0);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		need.setTime1(d);
		try {
			needsDAO.save(need);
			request.put("tip", "鍙戝竷鎴愬姛");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			request.put("tip", "鍙戝竷澶辫触");
		}
		return false;
	}

	public List findneeds(String city, int area0, int area1, int money0, int money1, int order) {
		String hql = "from Needs as needs";
		if (city != null) {
			hql = hql + " where city like '%" + city + "%'";
			if (!(area0 == 0 && area1 == 0)) {
				if (area1 != 0)
					hql = hql + " and area between " + area0 + " and " + area1;
				else
					hql = hql + " and area>" + area0;
			}
			if (!(money0 == 0 && money1 == 0)) {
				if (money1 != 0)
					hql = hql + " and money between " + money0 + " and " + money1;
				else
					hql = hql + " and money>" + money0;
			}
		} else {
			if (!(area0 == 0 && area1 == 0)) {
				if (area1 != 0)
					hql = hql + " where area between " + area0 + " and " + area1;
				else
					hql = hql + " where area>" + area0;
				if (!(money0 == 0 && money1 == 0)) {
					if (money1 != 0)
						hql = hql + " and money between " + money0 + " and " + money1;
					else
						hql = hql + " and money>" + money0;
				}
			} else {
				if (!(money0 == 0 && money1 == 0)) {
					if (money1 != 0)
						hql = hql + " where money between " + money0 + " and " + money1;
					else
						hql = hql + " where money>" + money0;
				}
			}
		}
		if (order == 1) {
			hql = hql + " order by time1 DESC";
		} else if (order == 2) {
			hql = hql + " order by area DESC";
		}
		System.out.println(hql);
		System.out.println(area0 + " " + area1 + " " + money0 + " " + money1);
		List list = needsDAO.findByHql(hql);
		return list;
	}

	public Needs getNeedsByID(int needsID) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		String hql = "from Needs where needsID=" + needsID + "";
		List list = needsDAO.findByHql(hql);
		Needs needs = null;
		int enrollment = 0;
		if (!list.isEmpty()) {
			needs = (Needs) list.get(0);
			for (Object s : needs.getDesigners()) {
			Designer designer = (Designer) s;
			enrollment++;
			needs.setEnrollment(enrollment);
			request.put("needs", needs);
		}
		}
		return needs;
	}

	public boolean SignUp(int needsID) {
		ActionContext ctx = ActionContext.getContext();
		session = (Map) ctx.get("session");
		Designer designer = (Designer) session.get("designer");
		Needs needs = (Needs) needsDAO.findById(needsID);
		needs.getDesigners().add(designer);
		needs.setEnrollment(needs.getEnrollment()+1);
		try {
			needsDAO.update(needs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	public boolean selectDes(Needs needs, Designer designer) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		Needs Needs = (Needs) needsDAO.findById(needs.getNeedsId());
		Designer Designer= (Designer) designerDAO.findById(designer.getDesignerId());
		if(Needs!=null && Designer !=null ) {
		request.put("needs", Needs);
		request.put("designer",Designer);
		return true;
		}
		else return false;
	}
	
}