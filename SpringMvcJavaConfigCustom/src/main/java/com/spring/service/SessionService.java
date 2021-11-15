package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entity.Visitor;
import com.spring.entity.VisitorCount;
import com.spring.entity.VisitorData;

@Service
public class SessionService 
{
	public SessionService()
	{
		
	}
	public void visitorCountUpdate(VisitorCount visitorCount)
	{
		visitorCount.setCount(visitorCount.getCount()+1);
	}
	public void visitorRegistry(VisitorData sessionVisitor,VisitorData currentVisitor)
	{
		List<Visitor> visitorList = sessionVisitor.getVisitorList();
		sessionVisitor.setVisitorName(currentVisitor.getVisitorName());
		sessionVisitor.setVisitorMail(currentVisitor.getVisitorMail());
		Visitor newVisitor = new Visitor(currentVisitor.getVisitorName(),currentVisitor.getVisitorMail());
		visitorList.add(newVisitor);
	}
}
