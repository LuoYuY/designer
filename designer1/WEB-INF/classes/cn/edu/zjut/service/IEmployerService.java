package cn.edu.zjut.service;

import java.io.File;

import cn.edu.zjut.po.Employer;

public interface IEmployerService {
	public boolean registerEmp(Employer emp);
	public boolean putEmployer(Employer employer);
	
	
	public boolean update3(Employer employer, File uprofile, String uprofileFileName);
}
