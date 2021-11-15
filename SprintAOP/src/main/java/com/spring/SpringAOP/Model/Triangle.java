package com.spring.SpringAOP.Model;

public class Triangle implements Shape{

	private String shapeName="";
	@Override
	public String getShapeType() {
		return shapeName;
	}
	public String getShapeName() {
		return shapeName;
	}
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}


}
