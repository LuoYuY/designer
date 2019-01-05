package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Comments;

public interface ICommentsDAO {
	public List findByHql(String hql);
	public Comments findById(Integer id);
	public void save(Comments instance);
	public void update(Comments instance);
	public void delete(Comments instance);
}
