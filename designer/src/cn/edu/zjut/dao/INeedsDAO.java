package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Needs;

public interface INeedsDAO {
	public void save(Needs need);
	public int find();
	public List findByHql(String hql);
	public Needs findById(int id);
	public void update(Needs instance);
}
