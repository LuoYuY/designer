package cn.edu.zjut.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.dao.IOrderrDAO;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Orderr;

public class OrderrService implements IOrderrService{
	private Map<String, Object> request, session;
	private IOrderrDAO orderrDAO=null;
	private IDesignerDAO designerDAO=null;
	private IEmployerDAO employerDAO=null;
	
	public void setOrderrDAO(IOrderrDAO orderrDAO) {
		this.orderrDAO=orderrDAO;
	}
	public void setDesignerDAO(IDesignerDAO designerDAO) {
		this.designerDAO=designerDAO;
	}
	
	public void setEmployerDAO(IEmployerDAO employerDAO) {
		this.employerDAO=employerDAO;
	}
	public boolean changeOrderrSt(String orderrId,String state) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		System.out.println(state);
		Orderr orderr = (Orderr) orderrDAO.findById(orderrId);
		orderr.setState(state);
		if(state.equals("完成"))
		{
			orderr.setFinishTime(new Timestamp(new Date().getTime()));
		}
		try {
			orderrDAO.update(orderr);
			request.put("orderr", orderr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

	public Orderr getOrderrByID(String orderrId) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		System.out.println(orderrId);
		Orderr orderr = (Orderr) orderrDAO.findById(orderrId);
		System.out.println(orderr.getTitle());
		request.put("orderr", orderr);
		return orderr;
	}
	public boolean SubmitOrderr(Orderr orderr, Designer designer, Employer employer1) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		session = (Map) ctx.get("session");
		Employer employer = (Employer)employerDAO.findById(employer1.getEmployerId());
		Designer Designer  = (Designer)designerDAO.findById(designer.getDesignerId());
		
		String orderrId =null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate1=sdf.format(new Date());
		String result="";
		Random random=new Random();
		for(int i=0;i<3;i++){
		 result+=random.nextInt(10);
		 }
		orderrId=newDate1+result;
		Orderr order=new Orderr(orderrId,orderr.getTitle(),orderr.getDescription(),new Timestamp(new Date().getTime()),orderr.getDesignTime(),null,orderr.getMoney(),"未付款",employer,Designer);
		try {
			orderrDAO.save(order);
			request.put("orderr",order);
			session.put("designer", Designer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
}
