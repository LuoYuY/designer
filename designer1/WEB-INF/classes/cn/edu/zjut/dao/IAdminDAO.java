package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Session;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Example;

public interface IAdminDAO {
	 public Session getSession();
     public void delete(Employer employer);
     public void delete(Designer designer);
     public Designer findD(String hql);
     public Employer findE(String hql);
     public Integer findCount1();
     public Integer findCount2();
     public void update1(Example example);
     public List findByhql(String hqlk);
     public Integer confirm(String name,String Id);
}
