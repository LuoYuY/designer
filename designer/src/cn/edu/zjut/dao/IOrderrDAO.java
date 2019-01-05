package cn.edu.zjut.dao;

import cn.edu.zjut.po.Orderr;

public interface IOrderrDAO {

	public void save(Orderr orderr);

	public Orderr findById(String orderrId);

	public void update(Orderr orderr);
}
