package cn.edu.zjut.service;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class PanoramaService implements IPanoramaService{
	private Map<String, Object> request, session;
	
	public void show(String path)
	{
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		request.put("path", path);
	}
}
