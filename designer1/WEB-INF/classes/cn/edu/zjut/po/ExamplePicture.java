package cn.edu.zjut.po;

public class ExamplePicture {
	private String picture1;
	private Example example;//案例
	
	public ExamplePicture() {}
	public ExamplePicture(String picture1) 
	{
		this.setPicture1(picture1);
	}
	public ExamplePicture(String picture1,Example example) 
	{
		this.setPicture1(picture1);
		this.setExample(example);
	}
	public Example getExample() {
		return example;
	}
	public void setExample(Example example) {
		this.example = example;
	}
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
}
