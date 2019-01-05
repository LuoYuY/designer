package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.po.ExamplePanorama;

public class ExamplePanoramaDAO extends BaseHibernateDAO implements IExamplePanoramaDAO{
	private Log log = LogFactory.getLog(ExamplePanoramaDAO.class);

	public List findByHql(String hql,Example example) {
		log.debug("finding ExamplePanorama instance by hql");
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setProperties(example);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	public ExamplePanorama findById(String id) {
		log.debug("finding ExamplePanorama instance by exampleId");
		ExamplePanorama e;
		try {
			e = (ExamplePanorama) getSession().get(ExamplePanorama.class, id);
			log.debug("find successful");
			return e;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	public void save(ExamplePanorama instance) {
		log.debug("saving ExamplePanorama instance");
		try {
			getSession().save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(ExamplePanorama instance) {
		log.debug("updating ExamplePanorama instance");
		try {
			getSession().update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(ExamplePanorama instance) {
		log.debug("deleting ExamplePanorama instance");
		try {
			getSession().delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
}
