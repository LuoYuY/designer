package cn.edu.zjut.dao;

import java.util.List;
import org.hibernate.Session;
import cn.edu.zjut.po.Designer;

public interface IDesignerDAO {
	public Session getSession();
	public List findByHql(String hql);
	public Designer findById(String id);
	public void save(Designer instance);
	public void update(Designer instance);
	public void delete(Designer instance);
	public Object merge(Designer instance);
	public String findDes();
}
