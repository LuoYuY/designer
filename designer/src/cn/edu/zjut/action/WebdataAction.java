package cn.edu.zjut.action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zjut.po.Comments;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.service.IExampleService;
import cn.edu.zjut.service.IWebdataService;

//merge with Admin Action
public class WebdataAction {

	private List datalist;

	public List getDatalist() {
		return datalist;
	}

	public void setDatalist(List datalist) {
		this.datalist = datalist;
	} 
	
	private IWebdataService webdataService =null;
	
	public void setWebdataService(IWebdataService webdataService)
	{
		this.webdataService=webdataService;
	}
	
	
	public String showDataChart()           //模糊搜索
	{
		System.out.println("in action");
		datalist = webdataService.findAll();
		return "success";
	}
	
}
