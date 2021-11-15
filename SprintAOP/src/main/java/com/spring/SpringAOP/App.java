package com.spring.SpringAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringAOP.Services.ShapeServices;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
       ShapeServices shape = context.getBean("ShapeServices",ShapeServices.class);
       shape.setShapeService("SpringAOP");
       shape.setShapeService1("SpringAOP1");
       shape.setandGetShapeService("SpringAOP");
       shape.getShapeType();
       shape.getShapeService1();
       ((ClassPathXmlApplicationContext)(context)).close();
    }
}
