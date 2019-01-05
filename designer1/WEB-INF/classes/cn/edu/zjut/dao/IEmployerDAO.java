package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Employer;

public interface IEmployerDAO {
	public List findByHql(String hql);
	public Employer findById(String id);
	public void save(Employer instance);
	public void update(Employer instance);
	public void delete(Employer instance);
	public String findEmp();
}
