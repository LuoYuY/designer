package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Query;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Webdata;

public class WebdataDAO extends BaseHibernateDAO implements IWebdataDAO {
	
	public List findByHql(String hql) { 
		try {
			String queryString = hql;
			System.out.println("hql="+hql);
			Query queryObject = getSession().createQuery(queryString); 
			//取最新的5条
			System.out.println("get!!!");
			queryObject.setMaxResults(5);
			return queryObject.list();
		} 
		catch (RuntimeException re) {  
			throw re;
		}
	}
	
	public Webdata findById(int id){
		Webdata e;
		try {
			e=(Webdata)getSession().get(Webdata.class,id);
			return e;
		}
		catch (RuntimeException re) { 
			throw re;
		}
	}
	
	
	public void save(Webdata instance) { 
		try {
			getSession().save(instance); 
		}
		catch (RuntimeException re) { 
			throw re;
		}
	}
	

}
