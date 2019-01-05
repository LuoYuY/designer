package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import cn.edu.zjut.po.Comments;

public class CommentsDAO extends BaseHibernateDAO implements ICommentsDAO{
	private Log log = LogFactory.getLog(CommentsDAO.class);
	
	public List findByHql(String hql) { 
		log.debug("finding Comments instance by hql"); 
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
	public Comments findById(Integer id){
		log.debug("finding Comments instance by CommentsId");
		Comments e;
		try {
			e=(Comments)getSession().get(Comments.class,id);
			log.debug("find successful");
			return e;
		}
		catch (RuntimeException re) { 
			log.error("find failed", re); 
			throw re;
		}
	}
	public void save(Comments instance) { 
		log.debug("saving Comments instance"); 
		try {
			getSession().save(instance); 
			log.debug("save successful");
		}
		catch (RuntimeException re) { 
			log.error("save failed", re); 
			throw re;
		}
	}
	public void update(Comments instance) {
		log.debug("updating Comments instance"); 
		try {
			getSession().update(instance); 
			log.debug("update successful");
		}
		catch (RuntimeException re) { 
			log.error("update failed", re); 
			throw re;
		}
	} 
	public void delete(Comments instance) {
		log.debug("deleting Comments instance"); 
		try {
			getSession().delete(instance); 
			log.debug("delete successful");
		} 
		catch (RuntimeException re) { 
			log.error("delete failed", re); 
			throw re;
		}
	}
}
