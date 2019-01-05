package cn.edu.zjut.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.EmployerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;

public class EmployerService implements IEmployerService {
	private Map<String, Object> request, session;
	IEmployerDAO employerDAO = null;

	public void setEmployerDAO(IEmployerDAO employerDAO) {this.employerDAO = employerDAO;}

	public boolean registerEmp(Employer emp) {
		String id = employerDAO.findEmp();
		if (id == null) {
			String a = "1" + "000000001";
			emp.setEmployerId(a);
		} else {
			Integer a = Integer.parseInt(id) + 1;
			String b = a.toString();
			emp.setEmployerId(b);
		}

		emp.setAccount(emp.getPhone());
		emp.setHmpgbkg("");
		emp.setProfilePhoto("");
		try {
			employerDAO.save(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean putEmployer(Employer employer) {
		ActionContext ctx = ActionContext.getContext();
		session = (Map) ctx.get("session");
		if (session.get("employer") != null) {
			String id = ((Employer) session.get("employer")).getEmployerId();
			if (employer.getEmployerId().equals(id))
				return true;                             //鏄泧涓绘湰浜�
			else {
				request = (Map) ctx.get("request");
				employer = employerDAO.findById(employer.getEmployerId());
				request.put("employer", employer);
				return false;                            //鏄叾浠栭泧涓�
			}
		} else {
			request = (Map) ctx.get("request");
			employer = employerDAO.findById(employer.getEmployerId());
			request.put("employer", employer);
			return false;                                  //鏄叾浠栬璁″笀
		}
	}
	
	
	
	public boolean update3(Employer employer, File uprofile, String uprofileFileName) {
		ActionContext ctx= ActionContext.getContext(); 
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");  
		if (uprofile != null) {
			String save = "C:\\designer\\employer\\profilephoto";
			save=copyfile(save,uprofile,uprofileFileName);
			employer.setProfilePhoto(uprofileFileName);
		}
		try {
			employerDAO.update(employer);
			request.put("tip", "修改成功");
			session.put("employer", employer);
			return true;
		} catch (Exception e) {
			request.put("tip", "修改失败");	
			e.printStackTrace();
			return false;
		} 
	}

	//上传图片
	public String copyfile(String path,File file, String filename) {
		File f = new File(path);	
		if (!f.exists())
			f.mkdirs();
		try {
			FileUtils.copyFile(file, new File(f, filename));		
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(path);
		path=path+"\\"+filename;
		System.out.println(path);
		return path;	
	}
}
