package com.spring.entity;

public class VisitorCount {
	private int count;

	public VisitorCount(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "VisitorCount [count=" + count + "]";
	}
	
}
