package cn.edu.zjut.dao; 

import java.util.List; 
import org.hibernate.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.edu.zjut.po.Example;

public class ExampleDAO extends BaseHibernateDAO implements IExampleDAO{
	private Log log = LogFactory.getLog(ExampleDAO.class);
	
	public List findByHql(String hql) { 
		log.debug("finding Example instance by hql"); 
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list();
		} 
		catch (RuntimeException re) { 
			log.error("find by hql failed", re); 
			throw re;
		}
	}
	public Example findById(Integer id){
		log.debug("finding Example instance by exampleId");
		Example e;
		try {
			e=(Example)getSession().get(Example.class,id);
			log.debug("find successful");
			return e;
		}
		catch (RuntimeException re) { 
			log.error("find failed", re); 
			throw re;
		}
	}
	public void save(Example instance) { 
		log.debug("saving Example instance"); 
		try {
			getSession().save(instance); 
			log.debug("save successful");
		}
		catch (RuntimeException re) { 
			log.error("save failed", re);
			throw re;
		}
	}
	public void update(Example instance) {
		log.debug("updating Example instance"); 
		try {
			getSession().merge(instance); 
			log.debug("update successful");
		}
		catch (RuntimeException re) { 
			log.error("update failed", re); 
			throw re;
		}
	} 
	public void delete(Example instance) {
		log.debug("deleting Example instance"); 
		try {
			getSession().delete(instance); 
			log.debug("delete successful");
		} 
		catch (RuntimeException re) { 
			log.error("delete failed", re); 
			throw re;
		}
	}
	public void merge(Example instance) {
		log.debug("deleting Example instance"); 
		try {
			getSession().merge(instance); 
			log.debug("delete successful");
		} 
		catch (RuntimeException re) { 
			log.error("delete failed", re); 
			throw re;
		}
	}
}



