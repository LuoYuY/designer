package cn.edu.zjut.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Example;
import cn.edu.zjut.service.DesignerService;
import cn.edu.zjut.service.IDesignerService;

public class DesignerAction extends ActionSupport {
	private Example example;
	private Designer designer;
	IDesignerService designerServ = null;
	// 鐏忎浇顥婃稉濠佺炊閺傚洣娆㈢仦鐐达拷锟�
	private File[] upload;
	private File[] upload2;
	
	
	private String designerID;  //鐠佹崘顓哥敮鍫㈢椽閸欙拷
	
	
	public String getDesignerID() {
		return designerID;
	}
	public void setDesignerID(String designerID) {
		this.designerID = designerID;
	}
	
	public IDesignerService getDesignerServ()
	{
		return designerServ;
	}
	public void setDesignerServ(IDesignerService designerServ)
	{
		System.out.println("setservice");
		this.designerServ=designerServ;
	}
	public File[] getUpload() {return upload;}
	public void setUpload(File[] upload) {this.upload = upload;}
	public File[] getUpload2() {return upload2;}
	public void setUpload2(File[] upload2) {this.upload2 = upload2;}
	public Example getExample() {return example;}
	public void setExample(Example example) {this.example = example;}
	public Designer getDesigner() {return designer;}
	public void setDesigner(Designer designer) {this.designer = designer;}
	
	
	public String gotoSubscribe()  //鐠哄疇娴嗛崚鎷岊嚉鐠佹崘顓哥敮鍫㈡畱妫板嫮瀹虫い鐢告桨
	{
		//System.out.println("designerID:"+designerID);
		Designer designer = new Designer();
		designer.setDesignerId(designerID);;
		designerServ.putDesigner(designer);
		return "success";
	}
	
	
	public String upload() throws Exception {               //娑撳﹣绱跺鍫滅伐
		if (designerServ.upload(example,upload,upload2))
			return "uploadSucccess";
		else
			return "uploadFail";
	}
	public String login() {                               //閻ц缍�
		if(designerServ.login(designer))
			return "loginSuccess";
		else
			return "loginFail";
	}
	public String putDesigner()                       //閸掋倖鏌囬悙鐟板毊閳ユ粏顔栭梻顔款啎鐠佲�崇瑎娑撳銆夐垾婵囧瘻闁筋喚娈戦弰顖濐啎鐠佲�崇瑎閺堫兛姹夋潻妯绘Ц閸忔湹绮禍锟�
	{
		if(designerServ.putDesigner(designer))
			return "myself";
		else
			return"others";
	}
	
	public String judgeIdentity()                       //鏉╂稑鍙嗛懛顏勭箒閻ㄥ嫪閲滄禍杞板瘜妞ゅ灚妞傞崚銈嗘焽閼奉亜绻侀弰顖濐啎鐠佲�崇瑎鏉╂ɑ妲搁梿鍥﹀瘜
	{
		if(designerServ.judgeIdentity())
			return "designer";
		else
			return "employer";
	}
	
	public String registerDes() {                        //鐠佹崘顓哥敮鍫熸暈閸愶拷
		if(designerServ.registerDes(designer)) {
			return "success";
		}
		return "fail";
	}
	
	public String viewExampleDetails()
	{
		if(designerServ.viewExampleDetails(designer, example))
			return "viewSuccess";
		else
			return "viewFail";
	}
	
	public String findAll() {                        
		if(designerServ.findAll())
			return "success";
		else
			return "false";
	}
	public String findByPraise() throws Exception {     
		if(designerServ.findByPraise())
			return "praiseSuccess";
		else
			return "praiseFail";
	}
	public String findByScore() throws Exception {        
		if(designerServ.findByScore())
			return "scoreSuccess";
		else
			return "scoreFail";
	}
	public String logout() {                         
		if(designerServ.logout())
			return "success";
		else return "false";
	}
	
	
	
	
	private File profile;
	public String profileFileName;
	private File certificate;
	public String certificateFileName;
	private int money1;
	private String message;
	public String update() {
		System.out.println(designer.getDesignerId());
		System.out.println(designer.getAccount());
		if(designerServ.update(designer,profile,profileFileName))
			return "success";
		else
			return "fail";
	}
	public String update2() {
		if(designerServ.update2(designer,certificate,certificateFileName))
			return "success";
		else
			return "fail";
	}
	
	public String recommend1() {
		if(designerServ.recommend1(money1))
			return "success";
		else
			return "fail";
	}
	public String recommend2() {
		if(designerServ.recommend2(money1))
			return "success";
		else
			return "fail";
	}
	public String recommend3() {
		if(designerServ.recommend3(message))
			return "success";
		else
			return "fail";
	}
	public File getProfile() {
		return profile;
	}
	public void setProfile(File profile) {
		this.profile = profile;
	}
	public String getProfileFileName() {
		return profileFileName;
	}
	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
	}
	public File getCertificate() {
		return certificate;
	}
	public void setCertificate(File certificate) {
		this.certificate = certificate;
	}
	public String getCertificateFileName() {
		return certificateFileName;
	}
	public void setCertificateFileName(String certificateFileName) {
		this.certificateFileName = certificateFileName;
	}
	public int getMoney1() {
		return money1;
	}
	public void setMoney1(int money1) {
		this.money1 = money1;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
