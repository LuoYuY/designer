package cn.edu.zjut.dao;

import org.apache.commons.logging.*;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Subscribe;

public class SubscribeDAO extends BaseHibernateDAO implements ISubscribeDAO{
	private Log log=LogFactory.getLog(SubscribeDAO.class);
	public Subscribe findById(int id){
		log.debug("finding Subscribe instance by subscribeID");
		Subscribe s;
		try {
			s=(Subscribe)getSession().get(Subscribe.class,id);
			log.debug("find successful");
			return s;
		}
		catch (RuntimeException re) { 
			log.error("find failed", re); 
			throw re;
		}
	}
	  public void save(Subscribe sub) {
		   log.debug("saving sub instance");
		   try {
			   getSession().save(sub);
			   log.debug("save successfully!");
			   
		   }catch(RuntimeException re) {
			   log.error("save fail",re);
			   throw re;
		   }
	   }
	  
	  public int find() {
		   log.debug("finding maxId instance");
		   try {
			   Integer maxValue=(Integer)getSession().createQuery("select max(subscribeID) from Subscribe ").uniqueResult();
			   if(maxValue==null) {
				   return 0;
			   }
			   return maxValue;
			  
		   }catch(RuntimeException re) {
			   log.error("find failed", re);
			   System.out.println("err");
			   throw re;
		   }
	  }
	@Override
	public void delete(Subscribe subscribe) {
		// TODO Auto-generated method stub
		log.debug("saving sub instance");
		   try {
			   
			   System.out.println("in subscribe delete");
			   getSession().delete(subscribe);
			   getSession().flush();  
			   log.debug("delete successfully!");
			   System.out.println("delete success!");
		   }catch(RuntimeException re) {
			   log.error("delete fail",re);
			   throw re;
		   }
	}
	
}
