package cn.edu.zjut.po;

public class ExamplePanorama {
	private String panorama1;
	private Example example;//案例
	
	public ExamplePanorama() {}
	public ExamplePanorama(String panorama1) 
	{
		this.setPanorama1(panorama1);
	}
	public ExamplePanorama(Example example,String panorama1)
	{
		this.setExample(example);
		this.setPanorama1(panorama1);
	}
	
	public Example getExample() {
		return example;
	}
	public void setExample(Example example) {
		this.example = example;
	}
	public String getPanorama1() {
		return panorama1;
	}
	public void setPanorama1(String panorama1) {
		this.panorama1 = panorama1;
	}
}
