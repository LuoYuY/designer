package cn.edu.zjut.tool;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.edu.zjut.dao.IWebdataDAO;
import cn.edu.zjut.po.Webdata;

public class UpdateDataTask extends TimerTask{

	private IWebdataDAO webdataDAO = null;
	public void setWebdataDAO(IWebdataDAO webdataDAO) {
		System.out.println("成功在Task中注入webdataDAO");
		this.webdataDAO = webdataDAO;
	}
	@Override
	public void run() {
		//更新数据库
		System.out.println("执行timertask。。。。");
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	    ServletContext servletContext = webApplicationContext.getServletContext();
	    
	    ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext); 
		 
	    webdataDAO = (IWebdataDAO)ac1.getBean("webdataDAO"); 
	    Webdata wd = new Webdata();
	    wd.setVisit((Integer)(servletContext.getAttribute("visit")));
	    wd.setDesignernum((Integer)(servletContext.getAttribute("designernum")));
	    wd.setEmployernum((Integer)(servletContext.getAttribute("employernum")));
	    wd.setExamplenum((Integer)(servletContext.getAttribute("examplenum")));
	    wd.setOrdernum((Integer)(servletContext.getAttribute("ordernum")));
		webdataDAO.save(wd);
		
	}

}
