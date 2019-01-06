package cn.edu.zjut.dao;

import java.util.List;
import cn.edu.zjut.po.Webdata;

public interface IWebdataDAO {
	public List findByHql(String hql);
	public Webdata findById(int id);
	public void save(Webdata instance);
}
