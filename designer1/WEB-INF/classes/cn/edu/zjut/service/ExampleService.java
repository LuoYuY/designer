package cn.edu.zjut.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.apache.log4j.BasicConfigurator;
import org.apache.mahout.cf.taste.common.TasteException;
//import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

//import com.mysql.cj.jdbc.MysqlDataSource;
import cn.edu.zjut.dao.CommentsDAO;
import cn.edu.zjut.dao.DesignerDAO;
import cn.edu.zjut.dao.EmployerDAO;
import cn.edu.zjut.dao.ExampleDAO;
import cn.edu.zjut.dao.ICommentsDAO;
import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.dao.IExampleDAO;
import cn.edu.zjut.po.Comments;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.DisplayCom;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Example;

public class ExampleService implements IExampleService{
	private List examples = new ArrayList();
	private List sortedexamples = new ArrayList();
	
	private Map<String,Object> request, session; //鑾峰彇request,session
	
	private IDesignerDAO designerDAO = null;
	private IExampleDAO exampleDAO = null;
	private IEmployerDAO employerDAO=null;
	private ICommentsDAO commentsDAO=null;
	
	

	public void setDesignerDAO(IDesignerDAO designerDAO) {this.designerDAO = designerDAO;}
	public void setExampleDAO(IExampleDAO exampleDAO) {this.exampleDAO = exampleDAO;}
	public void setEmployerDAO(IEmployerDAO employerDAO) {this.employerDAO = employerDAO;}
	public void setCommentsDAO(ICommentsDAO commentsDAO) {this.commentsDAO = commentsDAO;}

	public List findAllExamples(String condition) {
	
		ActionContext ctx= ActionContext.getContext();
		request=(Map) ctx.get("request");
		String hql = "from Example as ex where ex.description like '%"+condition+"%'";
		examples = exampleDAO.findByHql(hql);
		request.put("examples", examples);
		return examples;
	}
	
	public void putExample(Example example) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		example = exampleDAO.findById(example.getExampleId());
		request.put("example", example);
		Set<Comments> commentss = new HashSet();
		Set<DisplayCom> displayComs = new HashSet(0);
		commentss = example.getComments();
		Iterator<Comments> it = commentss.iterator();
		Designer designer = new Designer();
		Employer employer = new Employer();
		while (it.hasNext()) {
			DisplayCom displayCom = new DisplayCom();
			Comments comment = it.next();
			String str = comment.getReviewer();
			if (str.charAt(0) == '0') {
				designer = designerDAO.findById(str);
				displayCom.setProfilePhoto(designer.getProfilePhoto());
				displayCom.setAccount(designer.getAccount());
				displayCom.setContent(comment.getContent());
				displayCom.setTime(comment.getTime());
				displayComs.add(displayCom);
			} else {
				employer = employerDAO.findById(str);
				displayCom.setProfilePhoto(employer.getProfilePhoto());
				displayCom.setAccount(employer.getAccount());
				displayCom.setContent(comment.getContent());
				displayCom.setTime(comment.getTime());
				displayComs.add(displayCom);
			}
		}
		request.put("displayComs", displayComs);
	}

	public boolean review(Example example, Comments comments) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		session = (Map) ctx.get("session");

		// 鍒ゆ柇鏄璁″笀杩樻槸闆囦富
		if (session.get("designer") != null)// 濡傛灉鏄璁″笀
		{
			Designer designer = (Designer) session.get("designer");
			comments.setReviewer(designer.getDesignerId()); // 鎶婅璁″笀缂栧彿璧嬪�肩粰璇勮鑰�
		} else// 濡傛灉鏄泧涓�
		{
			Employer employer = (Employer) session.get("employer");
			comments.setReviewer(employer.getEmployerId());// 鎶婇泧涓荤紪鍙疯祴鍊肩粰璇勮鑰�
		}
		try {
			example = exampleDAO.findById(example.getExampleId());
			commentsDAO.save(comments);
			example.getComments().add(comments);
			exampleDAO.update(example);

			request.put("example", example);
			Set<Comments> commentss = new HashSet();
			Set<DisplayCom> displayComs = new HashSet(0);
			commentss = example.getComments();
			Iterator<Comments> it = commentss.iterator();
			Designer designer = new Designer();
			Employer employer = new Employer();
			while (it.hasNext()) {
				DisplayCom displayCom = new DisplayCom();
				Comments comment = it.next();
				String str = comment.getReviewer();
				if (str.charAt(0) == '0') {
					designer = designerDAO.findById(str);
					displayCom.setProfilePhoto(designer.getProfilePhoto());
					displayCom.setAccount(designer.getAccount());
					displayCom.setContent(comment.getContent());
					displayCom.setTime(comment.getTime());
					displayComs.add(displayCom);
				} else {
					employer = employerDAO.findById(str);
					displayCom.setProfilePhoto(employer.getProfilePhoto());
					displayCom.setAccount(employer.getAccount());
					displayCom.setContent(comment.getContent());
					displayCom.setTime(comment.getTime());
					displayComs.add(displayCom);
				}
			}
			request.put("displayComs", displayComs);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 

	}
	@Override
	public List findAll() {

	
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String hql = "from Example";
		System.out.println("yes22");
		examples = exampleDAO.findByHql(hql);
		System.out.println("yes11");
		request.put("examples", examples);
		return examples;
	}
	
	
	public List searchInFrame(String condition) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String hql = "from Example as ex where ex.description like '%"+condition+"%'";
		String hql2 = "from Example as ex where ex.description like '%"+condition+"%' order by ex.praise";
		examples = exampleDAO.findByHql(hql);
		sortedexamples = exampleDAO.findByHql(hql2);
		request.put("examples", examples);
		request.put("sortedexamples", sortedexamples);
		return examples;
	}
	
	
	public List searchInList(List<String> list) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		
		String hql = "from Example as ex where ex.style like '%"+list.get(1)+"%' and ex.area like '%"+list.get(2)+"%'";
		String hql2 = "from Example as ex where ex.style like '%"+list.get(1)+"%' and ex.area like '%"+list.get(2)+"%' order by ex.praise";
		
		examples = exampleDAO.findByHql(hql);
		sortedexamples = exampleDAO.findByHql(hql2);
		System.out.println("sortedexamples:"+sortedexamples.size());
		request.put("examples", examples);
		request.put("sortedexamples", sortedexamples);
		
		return examples;
	}
	
	public int praise(String exampleId)
	{
		Example example = exampleDAO.findById(Integer.parseInt(exampleId));
		System.out.println("example.getPraise():"+example.getPraise());
		example.setPraise(example.getPraise()+1);
		System.out.println("example.getPraise()222:"+example.getPraise());
		exampleDAO.update(example);
		System.out.println("ok");
		return example.getPraise();
		
	}
	@Override
	public void star(String exampleId) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map)ctx.get("session");
		Example example = exampleDAO.findById(Integer.parseInt(exampleId));
		System.out.println("example.getEm_collecters().size():"+example.getEm_collecters().size());
		System.out.println("(Employer)session.get(\"employer\")::"+((Employer)session.get("employer")).getAccount());
		example.getEm_collecters().add((Employer)(session.get("employer")));
		System.out.println("example.getEm_collecters().size()222:"+example.getEm_collecters().size());
		exampleDAO.update(example);
		System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkk");
	
	}
	
}
