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
//import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLBooleanPrefJDBCDataModel;
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

//import com.mysql.cj.jdbc.MysqlDataSource;
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
	Designer designer=new Designer();
	
	public void setDesignerDAO(IDesignerDAO designerDAO) {this.designerDAO = designerDAO;}
	public void setExampleDAO(IExampleDAO exampleDAO) {this.exampleDAO = exampleDAO;}
	public void setEmployerDAO(IEmployerDAO employerDAO) {this.employerDAO = employerDAO;}
	

	/**娑擃亝锟窖冨閹恒劏宕�
	 * Mysql閺佺増宓佸┃锟�
	 * star鐞涖劋鑵戦張锟�30閺夆�蹭簰娑撳﹥鏆熼幑顕�銆�
	 * **/
	
	
//	static private MysqlDataSource dataSource;
	private List<Example> recommendExamples = new ArrayList<Example>();
/*	public DesignerService()   //闁板秶鐤嗛弫鐗堝祦濠э拷
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
		
//		dataSource = new MysqlDataSource();
	//	dataSource.setURL("jdbc:mysql://localhost:3306/designer?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF8");
//		dataSource.setUser(user);
//		dataSource.setPassword(password);
	}
	
/*	public void recommend(String employerID)
	{
		//BasicConfigurator.configure();
		
		MySQLBooleanPrefJDBCDataModel datamodel = new MySQLBooleanPrefJDBCDataModel(dataSource, 
				"star", "collecter", "exampleID",null);
		//閸掆晝鏁eloadFromJDBCDataModel閸栧懓锛檍dbcDataModel,閸欘垯浜掗幎濠呯翻閸忋儱濮為崗銉ュ敶鐎涙顓哥粻妤嬬礉閸旂姴鎻╃拋锛勭暬闁喎瀹抽妴锟�
		ReloadFromJDBCDataModel model;
		try {
			model = new ReloadFromJDBCDataModel(datamodel);
			UserSimilarity similarity =new TanimotoCoefficientSimilarity(model);		//閻€劍鍩涢惄闀愭妧鎼达讣绱濇担璺ㄦ暏鐠嬮攱婀扮捄婵堫瀲閻╅晲鎶�鎼达拷
			UserNeighborhood neighborhood =new NearestNUserNeighborhood(5,similarity,model);    
			Recommender recommender= new GenericUserBasedRecommender(model,neighborhood,similarity);
			System.out.println("Long.parseLong(employerID)"+Long.parseLong(employerID));
			List<RecommendedItem> recommendations =recommender.recommend(Long.parseLong(employerID),4);//娑撹櫣鏁ら幋锟�1閹恒劏宕樻稉銈勯嚋ItemID
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
*/	
	
	
	public boolean login(Designer desi)
	{
		String phone=desi.getPhone();
		String password=desi.getPassword();
		ActionContext ctx= ActionContext.getContext();
		session=(Map)ctx.get("session");
		request=(Map)ctx.get("request");
		String hql = "from Designer where phone='" + phone+ "' and password='" + password + "'";
		String hql2 = "from Employer where phone='" + phone+ "' and password='" + password + "'";
		List list = designerDAO.findByHql(hql);  //閺屻儴顕楃拋鎹愵吀鐢牐銆�
		List list2 = employerDAO.findByHql(hql2); //閺屻儴顕楅弲顕�锟芥氨鏁ら幋鐤��
		if (!list.isEmpty())
		{
			Designer designer=(Designer)list.get(0);
			session.put("id", designer.getDesignerId());
			request.put("tip", "閻ц缍嶉幋鎰閿涳拷 ");
			session.put("designer", designer);
			return true;
		}
		else if(!list2.isEmpty())
		{
			Employer employer=(Employer)list2.get(0);
			session.put("id", employer.getEmployerId());
			session.put("employer", employer);
			System.out.println("in recommend:");
//			recommend(employer.getEmployerId());
//			session.put("recommendExamples", recommendExamples);
			System.out.println("in recommend:"+recommendExamples.size());
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean upload(Example example, File[] upload, File[] upload2) {
		// 1.閹峰灝鍩孲ervletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		// 閼惧嘲褰噐equest
		ActionContext ctx = ActionContext.getContext();
		request = (Map) ctx.get("request");
		session = (Map) ctx.get("session");
		try {
		    Designer designer = (Designer) session.get("designer");
			// 2.鐠嬪啰鏁ealPath閺傝纭堕敍宀冨箯閸欐牗鐗撮幑顔荤娑擃亣娅勯幏鐔烘窗瑜版洖绶遍崚鎵畱閻喎鐤勯惄顔肩秿
			String pathOfPanoramas = servletContext
					.getRealPath("/file/" + designer.getDesignerId() + "/" + example.getName() + "/panoramas/");
			String pathOfPictures = servletContext
					.getRealPath("/file/" + designer.getDesignerId() + "/" + example.getName() + "/pictures/");
			// 3.婵″倹鐏夋潻娆庨嚋閻喎鐤勯惃鍕窗瑜版洑绗夌�涙ê婀敍宀勬付鐟曚礁鍨卞锟�
			File fileOfPanoramas = new File(pathOfPanoramas);
			File fileOfPictures = new File(pathOfPictures);
			if (!fileOfPanoramas.exists()) {
				fileOfPanoramas.mkdirs();
			}
			if (!fileOfPictures.exists()) {
				fileOfPictures.mkdirs();
			}
			// 閸擃亜鍨忛敍姘Ω娑撳瓨妞傞弬鍥︽閸擃亜鍨忛幐鍥х暰閻ㄥ嫪缍呯純顕嗙礉楠炴湹绗栫紒娆庣铂闁插秴鎳￠崥宥冿拷锟� 濞夈劍鍓伴敍姘閺冭埖鏋冩禒鑸电梾閺堝绨�
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
			request.put("tip", "濡楀牅绶ユ稉濠佺炊閹存劕濮涢敍锟�");
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
				return true;                             //閺勵垵顔曠拋鈥崇瑎閺堫兛姹�
			else {
				request = (Map) ctx.get("request");
				designer = designerDAO.findById(designer.getDesignerId());
				request.put("designer", designer);
				return false;                            //閺勵垰鍙炬禒鏍啎鐠佲�崇瑎
			}
		} else {
			request = (Map) ctx.get("request");
			designer = designerDAO.findById(designer.getDesignerId());
			request.put("designer", designer);
			return false;                                  //閺勵垰鍙炬禒鏍厂娑擄拷
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
		// 閸掋倖鏌囬弰顖濐啎鐠佲�崇瑎鏉╂ɑ妲搁悽銊╂厂娑擄拷
		if (session.get("designer") != null)// 婵″倹鐏夐弰顖濐啎鐠佲�崇瑎
			return true;
		else// 婵″倹鐏夐弰顖炴厂娑擄拷
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
		System.out.println("designer.getDesignerId()锛�"+designer.getDesignerId());
		System.out.println("designer.getAccount()锛�"+designer.getAccount());
		System.out.println(designer.getPassword());
		if (profile != null) {
			String save = "C:\\designer\\designer\\profilephoto";
			save=copyfile(save,profile,profileFileName);
			designer.setProfilePhoto(profileFileName);
			System.out.println(save);
		}
		try {
			designerDAO.update(designer);
			request.put("tip", "淇敼涓汉璧勬枡鎴愬姛");
			session.put("designer", designer);
			return true;
		} catch (Exception e) {
			request.put("tip", "淇敼涓汉璧勬枡澶辫触");
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
			designer.setStatus("寰呭鏍�");
			System.out.println(save2);
		}
		Designer d=(Designer) session.get("designer");
		System.out.println(d.getDesignerId());
		d.setPrize(designer.getPrize());
		d.setCertificate(designer.getCertificate());
		d.setStatus(designer.getStatus());
		try {
			designerDAO.update(d);
			request.put("tip", "涓婁紶鎴愬姛锛岃鑰愬績绛夊緟绠＄悊鍛樺鏍�");
			session.put("designer", d);
			return true;
		} catch (Exception e) {
			request.put("tip", "涓婁紶澶辫触");
			e.printStackTrace();
			return false;
		} 
	}   

	//涓婁紶鍥剧墖
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
			request.put("tip", "鐢宠涓汉鎺ㄤ紭鎴愬姛锛岃鑰愬績绛夊緟绠＄悊鍛樻壒鍑�");
			session.put("designer", designer);
			return true;
		} catch (Exception e) {
			request.put("tip", "鐢宠涓汉鎺ㄤ紭澶辫触");	
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
			request.put("tip", "鐢宠妗堜緥鎺ㄤ紭澶辫触");
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
			request.put("tip", "鐢宠妗堜緥鎺ㄤ紭鎴愬姛锛岃鑰愬績绛夊緟绠＄悊鍛橀�氳繃鐢宠");
			return true;
		} catch (Exception e) {
			request.put("tip", "鐢宠妗堜緥鎺ㄤ紭澶辫触");
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean searchByAccount(String account) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map)ctx.get("session");
		request=(Map) ctx.get("request");
		String hql = "from Designer as d where d.account = 'account'";
		designer = designerDAO.findByAccount(hql);
		session.put("designer", designer);
		request.put("designer", designer);
		return true;
	}
}
