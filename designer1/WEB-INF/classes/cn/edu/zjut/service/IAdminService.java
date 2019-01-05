package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Example;

public interface IAdminService {
	public boolean Logout(String userId,String phone);
	public boolean Recommend(Designer designer);
	public boolean Recommend1(Example example,Designer designer);
	public List displayDes();
	public List displayExp();
	public List display();
}
