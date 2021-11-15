package com.spring.SpringAOP.Services;

import com.spring.SpringAOP.Aspect.Loggable;
import com.spring.SpringAOP.Model.Shape;

public class ShapeServices 
{
	Shape shape;
	private String shapeService="";
	private String shapeService1="";
	public ShapeServices(){}
	public ShapeServices(Shape shape)
	{
		this.shape=shape;
	}
	public void getShapeType()
	{
		System.out.println(shape.getShapeType());
	}
	public String getShapeService() {
		return shapeService;
	}
	public void setShapeService(String shapeService) {
		this.shapeService = shapeService;
		//throw(new RuntimeException());
	}
	public String setandGetShapeService(String shapeService) {
		this.shapeService = shapeService;
		System.out.println("setandGetShapeService ["+shapeService+"]");
		return shapeService+"Return";
	}
	@Loggable
	public String getShapeService1() {
		return shapeService1;
	}
	public void setShapeService1(String shapeService1) {
		this.shapeService1 = shapeService1;
	}
	
}
