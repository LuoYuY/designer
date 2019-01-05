package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Needs;

public interface INeedsService {
	public boolean wanted(Needs need);
	public List findneeds(String city,int area0,int area1,int money0,int money1,int order);
	public Needs getNeedsByID(int needsID);
	public boolean SignUp(int needsID);
	public boolean selectDes(Needs needs, Designer designer);
}
