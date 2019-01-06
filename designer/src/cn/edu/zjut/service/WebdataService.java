package cn.edu.zjut.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.dao.IOrderrDAO;
import cn.edu.zjut.dao.ISubscribeDAO;
import cn.edu.zjut.dao.IWebdataDAO;

public class WebdataService implements IWebdataService {
	private IWebdataDAO webdataDAO=null; //到时候删掉
	private List datalist = new ArrayList();
	private Map<String,Object> request, session; //获取request,session
	public void setWebdataDAO(IWebdataDAO webdataDAO) {this.webdataDAO = webdataDAO;}
	
	
	@Override
	public List findAll() {
		System.out.println("in find webdata");
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String hql = "from Webdata";
		datalist = webdataDAO.findByHql(hql);
		System.out.println("find webdata");
		request.put("datalist", datalist);
		return datalist;
	}
	
}
