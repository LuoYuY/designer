package cn.edu.zjut.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.opensymphony.xwork2.ActionContext;
import cn.edu.zjut.dao.DesignerDAO;
import cn.edu.zjut.dao.ExampleDAO;
import cn.edu.zjut.dao.IDesignerDAO;
import cn.edu.zjut.dao.IEmployerDAO;
import cn.edu.zjut.dao.IExampleDAO;
import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.po.ExamplePanorama;
import cn.edu.zjut.po.ExamplePicture;

public class DesignerService implements IDesignerService {

	private Map<String, Object> request, session;
	private IDesignerDAO designerDAO = null;
	private IExampleDAO exampleDAO = null;
	private IEmployerDAO employerDAO=null;
	
	public void setDesignerDAO(IDesignerDAO designerDAO) {this.designerDAO = designerDAO;}
	public void setExampleDAO(IExampleDAO exampleDAO) {this.exampleDAO = exampleDAO;}
	public void setEmployerDAO(IEmployerDAO employerDAO) {this.employerDAO = employerDAO;}
	

	/**涓�у寲鎺ㄨ崘
	 * Mysql鏁版嵁婧�
	 * star琛ㄤ腑鏈�30鏉′互涓婃暟鎹」
	 * **/
	
	
	static private MysqlDataSource dataSource;
	private List<Example> recommendExamples = new ArrayList<Example>();
	public DesignerService()   //閰嶇疆鏁版嵁婧�
	{
		System.out.println("in service");
		String driver = "com.mysql.cj.jdbc.Driver";
	
		String user = "root";
		String password = "lyy19971221";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/designer?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF8");
		dataSource.setUser(user);
		dataSource.setPassword(password);
	}
	
	public void recommend(String employerID)
	{
		//BasicConfigurator.configure();
		
		MySQLBooleanPrefJDBCDataModel datamodel = new MySQLBooleanPrefJDBCDataModel(dataSource, 
				"star", "collecter", "exampleID",null);
		//鍒╃敤ReloadFromJDBCDataModel鍖呰９jdbcDataModel,鍙互鎶婅緭鍏ュ姞鍏ュ唴瀛樿绠楋紝鍔犲揩璁＄畻閫熷害銆�
		ReloadFromJDBCDataModel model;
		try {
			model = new ReloadFromJDBCDataModel(datamodel);
			UserSimilarity similarity =new TanimotoCoefficientSimilarity(model);		//鐢ㄦ埛鐩镐技搴︼紝浣跨敤璋锋湰璺濈鐩镐技搴�
			UserNeighborhood neighborhood =new NearestNUserNeighborhood(5,similarity,model);    
			Recommender recommender= new GenericUserBasedRecommender(model,neighborhood,similarity);
			System.out.println("Long.parseLong(employerID)"+Long.parseLong(employerID));
			List<RecommendedItem> recommendations =recommender.recommend(Long.parseLong(employerID),4);//涓虹敤鎴�1鎺ㄨ崘涓や釜ItemID
			System.out.println("recommendations.size():"+recommendations.size());
			recommendExamples.clear();
			for(RecommendedItem recommendation :recommendations){
				System.out.println(recommendation.getItemID());
				recommendExamples.add(exampleDAO.findById((int)recommendation.getItemID()));
			}
			
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		
	}
	
	
	
	public boolean login(Designer desi)
	{
		String phone=desi.getPhone();
		String password=desi.getPassword();
		ActionContext ctx= ActionContext.getContext();
		session=(Map)ctx.get("session");
		request=(Map)ctx.get("request");
		String hql = "from Designer where phone='" + phone+ "' and password='" + password + "'";
		String hql2 = "from Employer where phone='" + phone+ "' and password='" + password + "'";
		List list = designerDAO.findByHql(hql);  //鏌ヨ璁捐甯堣〃
		List list2 = employerDAO.findByHql(hql2); //鏌ヨ鏅�氱敤鎴疯〃
		if (!list.isEmpty())
		{
			Designer designer=(Designer)list.get(0);
			session.put("id", designer.getDesignerId());
			request.put("tip", "鐧诲綍鎴愬姛锛� ");
			session.put("designer", designer);
			return true;
		}
		else if(!list2.isEmpty())
		{
			Employer employer=(Employer)list2.get(0);
			session.put("id", employer.getEmployerId());
			session.put("employer", employer);
			System.out.println("in recommend:");
			recommend(employer.getEmployerId());
			session.put("recommendExamples", recommendExamples);
			System.out.println("in recommend:"+recommendExamples.size());
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean upload(Example example, File[] upload, File[] upload2) {
		// 1.鎷垮埌ServletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		// 鑾峰彇request
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		session = (Map) ctx.get("session");
		try {
		    Designer designer = (Designer) session.get("designer");
			// 2.璋冪敤realPath鏂规硶锛岃幏鍙栨牴鎹竴涓櫄鎷熺洰褰曞緱鍒扮殑鐪熷疄鐩綍
			String pathOfPanoramas = servletContext
					.getRealPath("/file/" + designer.getDesignerId() + "/" + example.getName() + "/panoramas/");
			String pathOfPictures = servletContext
					.getRealPath("/file/" + designer.getDesignerId() + "/" + example.getName() + "/pictures/");
			// 3.濡傛灉杩欎釜鐪熷疄鐨勭洰褰曚笉瀛樺湪锛岄渶瑕佸垱寤�
			File fileOfPanoramas = new File(pathOfPanoramas);
			File fileOfPictures = new File(pathOfPictures);
			if (!fileOfPanoramas.exists()) {
				fileOfPanoramas.mkdirs();
			}
			if (!fileOfPictures.exists()) {
				fileOfPictures.mkdirs();
			}
			// 鍓垏锛氭妸涓存椂鏂囦欢鍓垏鎸囧畾鐨勪綅缃紝骞朵笖缁欎粬閲嶅懡鍚嶃�� 娉ㄦ剰锛氫复鏃舵枃浠舵病鏈変簡
			for (int i = 0; i < upload.length; i++) {
				upload[i].renameTo(new File(fileOfPanoramas, Integer.toString(i) + ".jpg"));
				ExamplePanorama panorama = new ExamplePanorama("file/" + designer.getDesignerId() + "/"
						+ example.getName() + "/panoramas/" + Integer.toString(i) + ".jpg");
				example.getPanoramas().add(panorama);
			}
			for (int i = 0; i < upload2.length; i++) {
				upload2[i].renameTo(new File(fileOfPictures, Integer.toString(i) + ".jpg"));
				ExamplePicture picture = new ExamplePicture("file/" + designer.getDesignerId() + "/" + example.getName()
						+ "/pictures/" + Integer.toString(i) + ".jpg");
				example.getPictures().add(picture);
			}
		    //exampleDAO.save(example);
			designer.getExamples_own().add(example);
			designerDAO.update(designer);
			request.put("tip", "妗堜緥涓婁紶鎴愬姛锛�");
			
			//update examplenum
            Integer count =(Integer)servletContext.getAttribute("examplenum");
            servletContext.setAttribute("examplenum", count+1);
	        
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean putDesigner(Designer designer) {
		ActionContext ctx = ActionContext.getContext();
		session = (Map) ctx.get("session");
		if (session.get("designer") != null) {
			String id = ((Designer) session.get("designer")).getDesignerId();
			if (designer.getDesignerId().equals(id))
				return true;                             //鏄璁″笀鏈汉
			else {
				request = (Map) ctx.get("request");
				designer = designerDAO.findById(designer.getDesignerId());
				request.put("designer", designer);
				return false;                            //鏄叾浠栬璁″笀
			}
		} else {
			request = (Map) ctx.get("request");
			designer = designerDAO.findById(designer.getDesignerId());
			request.put("designer", designer);
			return false;                                  //鏄叾浠栭泧涓�
		}
	}

	public boolean registerDes(Designer designer) {
     	String id=designerDAO.findDes();
     	if(id==null) {
     		String a="0"+"000000002";
     		designer.setDesignerId(a);
     	}
     	else {
     		Integer a=Integer.parseInt(id)+1;
     		String b=a.toString();
     		designer.setDesignerId(b);
     	}
     	designer.setAccount(designer.getPhone());
     	designer.setName("abc");
     	designer.setIDNumber("0000000");
     	designer.setHmpgbkg("");
     	designer.setProfilePhoto("");
     	
   	    try {
     	 designerDAO.save(designer);
     	 return true;
   	   }catch(Exception e) {
   		   e.printStackTrace();
		 }
		 return false;
	  }

	public boolean judgeIdentity() {
		ActionContext ctx = ActionContext.getContext();
		session = (Map) ctx.get("session");
		// 鍒ゆ柇鏄璁″笀杩樻槸鐢ㄩ泧涓�
		if (session.get("designer") != null)// 濡傛灉鏄璁″笀
			return true;
		else// 濡傛灉鏄泧涓�
			return false;
	}
	
	public boolean viewExampleDetails(Designer designer, Example example) {
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		DesignerDAO d_dao = new DesignerDAO();
		ExampleDAO e_dao = new ExampleDAO();

		example = e_dao.findById(example.getExampleId());
		designer = d_dao.findById(designer.getDesignerId());

		e_dao.getSession().close();
		d_dao.getSession().close();

		if (example == null || designer == null)
			return false;
		else {
			request.put("designer", designer);
			request.put("example", example);
			return true;
		}
	}
	
	public boolean findAll() {
		ActionContext ctx = ActionContext.getContext();
		String hql = "from cn.edu.zjut.po.Designer";
		List designers = designerDAO.findByHql(hql);
		request=(Map)ctx.get("request");
		request.put("designers", designers);
		return true;
	}
	public boolean findByPraise(){
		ActionContext ctx = ActionContext.getContext();
		String hql = "from cn.edu.zjut.po.Designer d where d.praise >=15";
		List designers = designerDAO.findByHql(hql);
		request=(Map)ctx.get("request");
		request.put("designers", designers);
		return true;
	}
	public boolean findByScore(){
		ActionContext ctx = ActionContext.getContext();
		String hql = "from cn.edu.zjut.po.Designer d where d.score >=5 ";
		List designers = designerDAO.findByHql(hql);
		request=(Map)ctx.get("request");
		request.put("designers", designers);
		return true;
	}
	public boolean logout() {
		ActionContext ctx= ActionContext.getContext();
		session=(Map)ctx.get("session");
		session.clear();
		return true;
	}
	
	

	
	
	public boolean update(Designer designer, File profile, String profileFileName) {
		System.out.println("in update");
		ActionContext ctx= ActionContext.getContext(); 
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request"); 
		System.out.println("designer.getDesignerId()："+designer.getDesignerId());
		System.out.println("designer.getAccount()："+designer.getAccount());
		System.out.println(designer.getPassword());
		if (profile != null) {
			String save = "C:\\designer\\designer\\profilephoto";
			save=copyfile(save,profile,profileFileName);
			designer.setProfilePhoto(profileFileName);
			System.out.println(save);
		}
		try {
			designerDAO.update(designer);
			request.put("tip", "修改个人资料成功");
			session.put("designer", designer);
			return true;
		} catch (Exception e) {
			request.put("tip", "修改个人资料失败");
			e.printStackTrace();
			return false;
		} 	
	}


	public boolean update2(Designer designer, File certificate, String certificateFileName) {
		ActionContext ctx= ActionContext.getContext(); 
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request"); 
		if (certificate != null) {
			String save2 = "C:\\designer\\designer\\certificate";
			save2=copyfile(save2,certificate,certificateFileName);
			designer.setCertificate(certificateFileName);
			designer.setStatus("待审核");
			System.out.println(save2);
		}
		Designer d=(Designer) session.get("designer");
		System.out.println(d.getDesignerId());
		d.setPrize(designer.getPrize());
		d.setCertificate(designer.getCertificate());
		d.setStatus(designer.getStatus());
		try {
			designerDAO.update(d);
			request.put("tip", "上传成功，请耐心等待管理员审核");
			session.put("designer", d);
			return true;
		} catch (Exception e) {
			request.put("tip", "上传失败");
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
		path=path+"\\"+filename;
		return path;	
	}


	public boolean recommend1(int money1) {
		ActionContext ctx= ActionContext.getContext(); 
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request"); 
		
		Designer designer=(Designer) session.get("designer");
		designer.setStatus1(1);
		designer.setMoney1(money1);

		try {
			designerDAO.update(designer);
			request.put("tip", "申请个人推优成功，请耐心等待管理员批准");
			session.put("designer", designer);
			return true;
		} catch (Exception e) {
			request.put("tip", "申请个人推优失败");	
			e.printStackTrace();
			return false;
		} 
	}


	public boolean recommend2(int money1) {
		ActionContext ctx= ActionContext.getContext(); 
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request"); 
		
		Designer designer=(Designer)session.get("designer");
		designer.setStatus1(3);
		designer.setMoney1(money1);		

		try {
			designerDAO.update(designer);
			session.put("designer", designer);
			return true;
		} catch (Exception e) {		
			request.put("tip", "申请案例推优失败");
			e.printStackTrace();
			return false;
		} 
	}


	public boolean recommend3(String message) {
		ActionContext ctx= ActionContext.getContext(); 
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request"); 
		
		Designer designer=(Designer)session.get("designer");
		designer.setMessage(message);
		designer.setStatus1(3);

		try {
			designerDAO.update(designer);
			session.put("designer", designer);
			request.put("tip", "申请案例推优成功，请耐心等待管理员通过申请");
			return true;
		} catch (Exception e) {
			request.put("tip", "申请案例推优失败");
			e.printStackTrace();
			return false;
		} 
	}
}
