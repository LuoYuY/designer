package cn.edu.zjut.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.dao.IExampleDAO;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.service.ExampleService;
import cn.edu.zjut.service.IDesignerService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IExampleDAO exampleDAO = (IExampleDAO) ctx.getBean("exampleDAO");
		IDesignerDAO designerDAO=(IDesignerDAO)ctx.getBean("designerDAO");
		IEmployerDAO employerDAO=(IEmployerDAO)ctx.getBean("employerDAO");
		Employer employer=employerDAO.findById("1000000001");
		System.out.println("该雇主的名字为："+employer.getName());
		Employer user = employerDAO.findById("1000000001");
		Designer user1 = designerDAO.findById("0000000001");
		System.out.println("该雇主的名字为："+user.getName());
		System.out.println("该设计师的名字为："+user1.getName());
	}
}
