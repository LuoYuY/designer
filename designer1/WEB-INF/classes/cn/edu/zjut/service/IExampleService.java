package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Comments;
import cn.edu.zjut.po.Example;

public interface IExampleService {
	public List findAllExamples(String condition);
	public void putExample(Example example);
	public boolean review(Example example, Comments comments);
	public List findAll();
	public List searchInFrame(String condition);
	public List searchInList(List<String> conditionList);
	public int praise(String exampleId);
	public void star(String exampleId);
}
