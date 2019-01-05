package cn.edu.zjut.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.edu.zjut.po.Needs;
import cn.edu.zjut.po.Orderr;

public class OrderrDAO extends BaseHibernateDAO implements IOrderrDAO{
	private Log log = LogFactory.getLog(OrderrDAO.class);
	
	public void save(Orderr orderr) {
		log.debug("saving orderr instance");
		try {
			getSession().save(orderr);
			log.debug("save successfully!");

		} catch (RuntimeException re) {
			log.error("save fail", re);
			throw re;
		}
	}

	public Orderr findById(String id) {
		log.debug("finding Orderr instance by exampleId");
		Orderr o;
		try {
			o= (Orderr) getSession().get(Orderr.class, id);
			log.debug("find successful");
			return o;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	public void update(Orderr order) {
		log.debug("updating order instance"); 
		try {
			getSession().update(order); 
			log.debug("update successful");
		}
		catch (RuntimeException re) { 
			log.error("update failed", re); 
			throw re;
		}
	}
}
