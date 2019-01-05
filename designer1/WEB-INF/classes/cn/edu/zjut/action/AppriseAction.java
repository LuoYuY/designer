package cn.edu.zjut.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.zjut.po.Apprise;
import cn.edu.zjut.service.IAppriseService;

public class AppriseAction {
	private Apprise apprise;
	IAppriseService appriseServ = null;

	public void setAppriseServ(IAppriseService appriseServ) {
		this.appriseServ = appriseServ;
	}

	public Apprise getApprise() {
		return apprise;
	}

	public void setApprise(Apprise apprise) {
		this.apprise = apprise;
	}

	public String apprise() {
		String message;
		HttpServletRequest request = ServletActionContext.getRequest();
		if (appriseServ.apprise(apprise)) {
			message = "保存成功!";
			request.setAttribute("tipMessage", message);
			return "success";
		}
		message = "保存失败!";
		request.setAttribute("tipMessage", message);
		return "fail";
	}

}
