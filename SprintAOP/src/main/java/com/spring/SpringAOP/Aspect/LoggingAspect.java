package com.spring.SpringAOP.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect 
{
	@Before("execution(public String com.spring.SpringAOP.Model.Circle.getShapeType())")
	public void loggingCircle()
	{
		System.out.println("Logging Before Circle Method");
	} 
	@Before("execution(public String com.spring.SpringAOP.Model.Triangle.getShapeType())")
	public void loggingTriangle()
	{
		System.out.println("Logging Before Triangle Method");
	}
	@Before("genericExpression()")
	public void loggingGet()
	{
		System.out.println("Logging Before Get Method");
	}
	@Before("genericExpression() && withinExpression()")
	public void jointPointExpression(JoinPoint jPoint)
	{
		System.out.println("JointPointExpression["+jPoint+"]");
	}
	@Before("args(shapeServices)")
	public void  argsExpression(String shapeServices)
	{
		System.out.println("ArgsExpression["+shapeServices+"]");
	}
	
	@After("execution(public String com.spring.SpringAOP.Model.Circle.getShapeType())")
	public void afterExpression()
	{
		System.out.println("Logging After Circle Method");
	}
	@AfterReturning(pointcut="args(shapeName)",returning = "returnValue")
	public void afterReturningExpression(String shapeName,String returnValue)
	{
		System.out.println("Logging After Returning Circle Method ["+shapeName+"]["+returnValue+"]");
	}
	@AfterThrowing(pointcut="args(String)",throwing = "ex")
	public void afterThrowExpression(Exception ex)
	{
		System.out.println("Logging After Throws Exception Method ["+ex+"]");
	}
	@Around("execution(public String setandGetShapeService(..))")
	public void aroundExpression(ProceedingJoinPoint joinPoint)
	{
		try {
			System.out.println("AroundExpression Before Aspect");
			joinPoint.proceed();
			System.out.println("AroundExpression After Aspect");
		} catch (Throwable e) {

			System.out.println("AroundExpression Exception");
			e.printStackTrace();
		}
	}
	
	@Around("@annotation(Loggable)")
	public void annotationAOP(ProceedingJoinPoint joinPoint)
	{
		System.out.println("AOP Using Annotation");
	}
	@Pointcut("execution(* get*())")
	public void genericExpression(){}
	
	@Pointcut("within(com.spring.SpringAOP.Model.Triangle)")
	public void withinExpression()	{}
	
	
}
