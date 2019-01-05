package cn.edu.zjut.dao;

import java.util.List;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.po.ExamplePicture;

public interface IExamplePictureDAO {
	public List findByHql(String hql,Example example);
	public ExamplePicture findById(String id);
	public void save(ExamplePicture instance);
	public void update(ExamplePicture instance);
	public void delete(ExamplePicture instance);
}
