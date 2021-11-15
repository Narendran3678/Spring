package com.spring.entity;

import java.util.ArrayList;
import java.util.List;

public class VisitorData 
{
	private String visitorName;
	private String visitorMail;
	private List<Visitor> visitorList = new ArrayList<Visitor>();;
	public VisitorData()
	{
		
	}
	public VisitorData(String visitorName, String visitorMail, List<Visitor> visitorList) {
		super();
		this.visitorName = visitorName;
		this.visitorMail = visitorMail;
		this.visitorList = visitorList;
	}
	public List<Visitor> getVisitorList() {
		return visitorList;
	}
	public void setVisitorList(List<Visitor> visitorList) {
		this.visitorList = visitorList;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public String getVisitorMail() {
		return visitorMail;
	}
	public void setVisitorMail(String visitorMail) {
		this.visitorMail = visitorMail;
	}
	@Override
	public String toString() {
		return "VisitorData [visitorName=" + visitorName + ", visitorMail=" + visitorMail + ", visitorList=" + visitorList
				+ "]";
	}
	

}
