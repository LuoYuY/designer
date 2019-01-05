package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Needs;

public class NeedsDAO extends BaseHibernateDAO implements INeedsDAO {
	private Log log = LogFactory.getLog(NeedsDAO.class);

	public Needs findById(int id) {
		log.debug("finding Designer instance by exampleId");
		Needs n;
		try {
			n = (Needs) getSession().get(Needs.class, id);
			log.debug("find successful");
			return n;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}
	public List findByHql(String hql) {
		log.debug("finding Needs instance by hql");
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}
	public void update(Needs instance) {
		log.debug("updating Needs instance"); 
		try {
			getSession().update(instance); 
			log.debug("update successful");
		}
		catch (RuntimeException re) { 
			log.error("update failed", re); 
			throw re;
		}
	} 
	public void save(Needs need) {
		log.debug("saving need instance");
		try {
			getSession().save(need);
			log.debug("save successfully!");

		} catch (RuntimeException re) {
			log.error("save fail", re);
			throw re;
		}
	}

	public int find() {
		log.debug("finding maxId instance");
		try {
			Integer maxValue = (Integer) getSession().createQuery("select max(needsId) from Needs").uniqueResult();
			if (maxValue == null) {
				return 0;
			}
			return maxValue;

		} catch (RuntimeException re) {
			log.error("find failed", re);
			System.out.println("err");
			throw re;
		}
	}
}
