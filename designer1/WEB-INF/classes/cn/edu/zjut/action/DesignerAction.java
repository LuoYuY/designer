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
	// 閻忓繋娴囬ˉ濠冪▔婵犱胶鐐婇柡鍌氭矗濞嗐垻浠﹂悙杈炬嫹閿燂拷
	private File[] upload;
	private File[] upload2;
	
	
	private String designerID;  //閻犱焦宕橀鍝ユ暜閸垻妞介柛娆欐嫹
	private String account;
	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
		
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
	
	
	public String gotoSubscribe()  //閻犲搫鐤囧ù鍡涘礆閹峰矈鍤夐悹浣瑰礃椤撳摜鏁崼銏＄暠濡澘瀚�硅櫕銇勯悽鍛婃〃
	{
		//System.out.println("designerID:"+designerID);
		Designer designer = new Designer();
		designer.setDesignerId(designerID);;
		designerServ.putDesigner(designer);
		return "success";
	}
	
	
	public String upload() throws Exception {               //濞戞挸锕ｇ槐璺侯浖閸粎浼�
		if (designerServ.upload(example,upload,upload2))
			return "uploadSucccess";
		else
			return "uploadFail";
	}
	public String login() {                               //闁谎嗩嚙缂嶏拷
		if(designerServ.login(designer))
			return "loginSuccess";
		else
			return "loginFail";
	}
	public String putDesigner()                       //闁告帇鍊栭弻鍥倷閻熸澘姣婇柍銉︾矎椤旀牠姊婚娆惧晭閻犱讲锟藉磭鐟庡☉鎾愁煼閵嗗鍨惧┑鍥х樆闂佺瓔鍠氬▓鎴﹀及椤栨繍鍟庨悹浣诧拷宕囩憥闁哄牜鍏涘Ч澶嬫交濡粯笑闁稿繑婀圭划顒佺閿燂拷
	{
		if(designerServ.putDesigner(designer))
			return "myself";
		else
			return"others";
	}
	
	public String judgeIdentity()                       //閺夆晜绋戦崣鍡涙嚊椤忓嫮绠掗柣銊ュ闁叉粍绂嶆潪鏉跨槣濡炪倕鐏氬鍌炲礆閵堝棙鐒介柤濂変簻缁讳線寮伴婵愬晭閻犱讲锟藉磭鐟庨弶鈺偵戝Σ鎼佹⒖閸ワ箑鐦�
	{
		if(designerServ.judgeIdentity())
			return "designer";
		else
			return "employer";
	}
	
	public String registerDes() {                        //閻犱焦宕橀鍝ユ暜閸喐鏆堥柛鎰舵嫹
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
	
	public String searchByAccount() // 妯＄硦鎼滅储
	{
		if (designerServ.searchByAccount(account))
			return "idSuccess";
		else
			return "idFail";
	}
}
