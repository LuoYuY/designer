package cn.edu.zjut.dao;

import cn.edu.zjut.po.Subscribe;

public interface ISubscribeDAO {
	public void save(Subscribe sub);
	public int find();
	public Subscribe findById(int id);
	public void delete(Subscribe subscribe);
}
