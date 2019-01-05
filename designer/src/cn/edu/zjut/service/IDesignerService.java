package cn.edu.zjut.service;

import java.io.File;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Example;

public interface IDesignerService {
	public boolean upload(Example example, File[] upload, File[] upload2);
	public boolean viewExampleDetails(Designer designer, Example example);
	public boolean putDesigner(Designer designer);
	public boolean judgeIdentity();
	public boolean login(Designer desi);
	public boolean registerDes(Designer designer);
	public boolean findAll();
	public boolean findByPraise();
	public boolean findByScore();
	public boolean logout();
	
	public boolean update(Designer designer, File profile, String profileFileName);
	public boolean update2(Designer designer, File certificate, String certificateFileName);
	public boolean recommend1(int money1);
	public boolean recommend2(int money1);
	public boolean recommend3(String message);
}
