package cn.edu.zjut.po;

import java.util.HashSet;
import java.util.Set;

public class Designer {
	private String designerId;
	private String account;
	private String name;
	private String password;
	private String IDNumber;
	private String phone;
	private String email;
	private Boolean sex;
	private String region;
	private String wechat;
	private String qq;
	private Integer score;
	private String profilePhoto;
	private String hmpgbkg;
	private String introduction;
	private Integer fans;
	private Integer praise;
	private String certificate;
	private String status;
	private String profound;
	private String introduce;
	private String prize;
	private String message;
	private Integer status1;
	private Integer money1;
	
	
	
	private Set examples_own=new HashSet(0);
	private Set examples_star=new HashSet(0);
	private Set designer_follow=new HashSet(0);
	private Set orderrs=new HashSet(0);
	private Set needs=new HashSet(0);
	private Set subscribe=new HashSet(0);
	
	public Designer() {}
	public Designer(String designerId)
	{
		this.setDesignerId(designerId);
	}
	
	
	public Designer(String designerId,String account,String name,String password,String IDNumber,String phone,
			String email,Boolean sex,String region,String wechat,String qq,Integer score,String profilePhoto,
			String hmpgbkg,String introduction,Integer fans,Integer praise,Set examples_own,Set examples_star,
			Set designer_follow,Set orderrs,Set<Needs> needs,String certificate,String status,String profound,
			String introduce,String prize,String message,Integer status1,Integer money1)
	{
		this.setDesignerId(designerId);
		this.setAccount(account);
		this.setName(name);
		this.setPassword(password);
		this.setIDNumber(IDNumber);
		this.setPhone(phone);
		this.setEmail(email);
		this.setSex(sex);
		this.setRegion(region);
		this.setWechat(wechat);
		this.setQq(qq);
		this.setScore(score);
		this.setProfilePhoto(profilePhoto);
		this.setHmpgbkg(hmpgbkg);
		this.setIntroduction(introduction);
		this.setFans(fans);
		this.setPraise(praise);
		this.setExamples_star(examples_star);
		this.setDesigner_follow(designer_follow);
		this.setOrderrs(orderrs);
		this.setNeeds(needs);
		this.setStatus(status);
		this.setMessage(message);
		this.setStatus1(status1);
		this.setMoney1(money1);
	}
	
	public String getDesignerId() {
		return designerId;
	}
	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public String getHmpgbkg() {
		return hmpgbkg;
	}
	public void setHmpgbkg(String hmpgbkg) {
		this.hmpgbkg = hmpgbkg;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getFans() {
		return fans;
	}
	public void setFans(Integer fans) {
		this.fans = fans;
	}
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public Set getExamples_own() {
		return examples_own;
	}
	public void setExamples_own(Set examples_own) {
		this.examples_own = examples_own;
	}
	public Set getExamples_star() {
		return examples_star;
	}
	public void setExamples_star(Set examples_star) {
		this.examples_star = examples_star;
	}
	public Set getDesigner_follow() {
		return designer_follow;
	}
	public void setDesigner_follow(Set designer_follow) {
		this.designer_follow = designer_follow;
	}
	public Set getOrderrs() {
		return orderrs;
	}
	public void setOrderrs(Set orderrs) {
		this.orderrs = orderrs;
	}
	public Set getNeeds() {
		return needs;
	}
	public void setNeeds(Set needs) {
		this.needs = needs;
	}
	public Set getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Set subscribe) {
		this.subscribe = subscribe;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProfound() {
		return profound;
	}
	public void setProfound(String profound) {
		this.profound = profound;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus1() {
		return status1;
	}
	public void setStatus1(Integer status1) {
		this.status1 = status1;
	}
	public Integer getMoney1() {
		return money1;
	}
	public void setMoney1(Integer money1) {
		this.money1 = money1;
	}
	
}
