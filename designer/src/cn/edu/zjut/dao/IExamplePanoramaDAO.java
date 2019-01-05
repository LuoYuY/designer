package cn.edu.zjut.dao;

import java.util.List;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.po.ExamplePanorama;

public interface IExamplePanoramaDAO {
	public List findByHql(String hql,Example example);
	public ExamplePanorama findById(String id);
	public void save(ExamplePanorama instance);
	public void update(ExamplePanorama instance);
	public void delete(ExamplePanorama instance);
}
