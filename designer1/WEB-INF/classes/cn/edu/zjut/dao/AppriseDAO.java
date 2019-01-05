package cn.edu.zjut.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Apprise;

public class AppriseDAO extends BaseHibernateDAO implements IAppriseDAO{
	private Log log=LogFactory.getLog(AppriseDAO.class);
	 public void save(Apprise appr) {
		   log.debug("saving appr instance");
		   try {
			   getSession().save(appr);
			   log.debug("save successfully!");
			   
		   }catch(RuntimeException re) {
			   log.error("save fail",re);
			   throw re;
		   }
	   }
	 
	/* public int find() {
		   log.debug("finding maxId instance");
		   try {
			   Integer maxValue=(Integer)getSession().createQuery("select max(appriseId) from Apprise ").uniqueResult();
			   if(maxValue==null) {
				   return 0;
			   }
			   return maxValue;
			  
		   }catch(RuntimeException re) {
			   log.error("find failed", re);
			   System.out.println("err");
			   throw re;
		   }
	  }*/

}
