package cn.edu.zjut.action;

import cn.edu.zjut.service.IPanoramaService;

public class PanoramaAction {
	private String path;
	IPanoramaService panoramaServ=null;
	
	public void setPanoramaServ(IPanoramaService panoramaServ) {this.panoramaServ=panoramaServ;}
	public String getPath() {return path;}
	public void setPath(String path) {this.path = path;}
	
	public String show()
	{
		panoramaServ.show(path);
		return "showSuccess";
	}
}
