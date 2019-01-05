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
import cn.edu.zjut.po.Employer;

public class EmployerDAO extends BaseHibernateDAO implements IEmployerDAO {
	private Log log = LogFactory.getLog(EmployerDAO.class);

	public List findByHql(String hql) {
		log.debug("finding Employer instance by hql");
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	public Employer findById(String id) {
		log.debug("finding Employer instance by exampleId");
		Employer e;
		try {
			e = (Employer) getSession().get(Employer.class, id);
			log.debug("find successful");
			return e;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	public void save(Employer instance) {
		log.debug("saving Employer instance");
		try {
			getSession().save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Employer instance) {
		log.debug("updating Employer instance");
		try {
			getSession().update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(Employer instance) {
		log.debug("deleting Employer instance");
		try {
			getSession().delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public String findEmp() {
		log.debug("finding maxId instance");
		try {
			String maxValue = (String) getSession().createQuery("select max(employerId) from Employer ").uniqueResult();
			if (maxValue == null) {
				return null;
			}
			return maxValue;

		} catch (RuntimeException re) {
			log.error("find failed", re);
			System.out.println("err");
			throw re;
		}
	}

}
