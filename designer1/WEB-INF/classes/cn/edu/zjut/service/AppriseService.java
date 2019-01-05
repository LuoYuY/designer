package cn.edu.zjut.service;

import java.sql.Timestamp;
import java.util.Map;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.dao.AppriseDAO;
import cn.edu.zjut.dao.IAppriseDAO;
import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.po.Apprise;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;

public class AppriseService implements IAppriseService {
	private Map<String, Object> request, session;
	private IAppriseDAO appriseDAO = null;

	public IAppriseDAO getAppriseDAO() {
		return appriseDAO;
	}

	public void setAppriseDAO(IAppriseDAO appriseDAO) {
		this.appriseDAO = appriseDAO;
	}

	public boolean apprise(Apprise appr) {
/*		int id = appriseDAO.find();
		appr.setAppriseId(id + 1);
		Employer user = employerDAO.findById("1000000001");
		appr.setEmpolyer(user);
		Designer user1 = designerDAO.findById("0000000001");
		appr.setDesigner(user1);*/
		try {
			appriseDAO.save(appr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
