package com.springboot.entity;

import java.util.*;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Courses 
{
	@JsonIgnore
	private long id;
	
	@Size(min=3,message="Course Name Should be greater than 3 Character")
	private String courseName;
	private String courseDuration;
	private List<Courses> listUser = new ArrayList<Courses>();
	
	public Courses() 
	{
		Courses courses = new Courses(1,"Spring Core","1 Month");
		listUser.add(courses);
		courses = new Courses(2,"Spring MVC","2 Month");
		listUser.add(courses);
		courses = new Courses(3,"Spring Boot","1.5 Month");
		listUser.add(courses);
	}
	public Courses(long id, String courseName, String courseDuration) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	public List<Courses> getListUser() {
		return listUser;
	}
	public void setListUser(List<Courses> listUser) {
		this.listUser = listUser;
	}
	@Override
	public String toString() {
		return "Courses [id=" + id + ", courseName=" + courseName + ", courseDuration=" + courseDuration + "]";
	}
	
}
