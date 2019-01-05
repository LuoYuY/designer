package cn.edu.zjut.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.dao.IOrderrDAO;
import cn.edu.zjut.dao.ISubscribeDAO;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Orderr;
import cn.edu.zjut.po.Subscribe;

public class SubscribeService implements ISubscribeService {
	private Map<String, Object> request, session;
	private ISubscribeDAO subscribeDAO = null;
	private IOrderrDAO orderrDAO = null;
	private IEmployerDAO employerDAO=null; //到时候删掉
	private IDesignerDAO designerDAO=null; //到时候删掉

	public void setSubscribeDAO(ISubscribeDAO subscribeDAO) {this.subscribeDAO = subscribeDAO;}
	public void setEmployerDAO(IEmployerDAO employerDAO) {this.employerDAO=employerDAO;}
	public void setDesignerDAO(IDesignerDAO designerDAO) {this.designerDAO=designerDAO;}
	
	public IOrderrDAO getOrderrDAO() {
		return orderrDAO;
	}
	public void setOrderrDAO(IOrderrDAO orderrDAO) {
		this.orderrDAO = orderrDAO;
	}
	public boolean subscribe(Subscribe sub,String employerId,String designerId) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map)ctx.get("request");
		int id = subscribeDAO.find();
		sub.setSubscribeID(id + 1);
		Employer user = employerDAO.findById(employerId);
		sub.setSubscriber(user);
		Designer user1 = designerDAO.findById(designerId);
		sub.setScriber(user1);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		sub.setTime(d);
		request.put("designer",user1);
		try {
			subscribeDAO.save(sub);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void putSubscribe(Subscribe subscribe) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map)ctx.get("request");
		subscribe = subscribeDAO.findById(subscribe.getSubscribeID());
		request.put("subscribe", subscribe);
		Employer subscriber=subscribe.getSubscriber();
		request.put("subscriber", subscriber);
		request.put("scriber", subscribe.getScriber());
		
		System.out.println("该预约的预约者为："+subscriber.getName());
		System.out.println("该预约的设计师为："+subscribe.getScriber().getName());
		

	}
	@Override
	public void accept(String subscribeID) {
		
		ActionContext ctx = ActionContext.getContext();
		request = (Map)ctx.get("request");
		session=(Map)ctx.get("session");
		int id = Integer.parseInt(subscribeID);
		// TODO Auto-generated method stub
		Subscribe subscribe = subscribeDAO.findById(id);
		subscribeDAO.delete(subscribe);
		
		
		System.out.println("before order.getDesigner()"+subscribe.getScriber().getName()+subscribe.getScriber().getPhone());
		System.out.println("before order.getDesigner().size() sub order"+subscribe.getScriber().getSubscribe().size()+"   "+subscribe.getScriber().getOrderrs().size());
		
		Orderr order = new Orderr();

		Timestamp beginTime = new Timestamp(System.currentTimeMillis());
		order.setBeginTime(beginTime);
		
		order.setDesigner(subscribe.getScriber());
		order.setEmployer(subscribe.getSubscriber());
		order.setMoney(subscribe.getMoney());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate=sdf.format(new Date());
		String result="";
		Random random=new Random();
		for(int i=0;i<3;i++){
			result+=random.nextInt(10);
		}
		order.setOrderrId(newDate+result);
		order.setState("进行中");
		order.setTitle(subscribe.getTitle());
		
		System.out.println("in save");
		orderrDAO.save(order);
		System.out.println("out save");
		
		//request.put("order",order);
		//request.put("designer",order.getDesigner());
		//Object obj = session.get("designer");
		Designer designer = designerDAO.findById(order.getDesigner().getDesignerId());
		session.put("designer", designer);
		//designer.getOrderrs().add(order);
		//designer.getSubscribe().remove(subscribe);
		System.out.println("after order.getDesigner()"+designer.getName()+designer.getPhone());
		System.out.println("after order.getDesigner().size() sub order"+designer.getSubscribe().size()+"   "+designer.getOrderrs().size());
		
	}

	@Override
	public void reject(String subscribeID) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(subscribeID);
		// TODO Auto-generated method stub
		Subscribe subscribe = subscribeDAO.findById(id);
		subscribeDAO.delete(subscribe);
	}
}
