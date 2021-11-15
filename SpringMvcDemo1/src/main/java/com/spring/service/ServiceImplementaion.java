package com.spring.service;

import java.util.*;

public class ServiceImplementaion implements ServiceInterface {

	@Override
	public List<String> getMessage(String name) {
		
		List<String> message = new ArrayList<>();
		message.add(name);
		return message;
	}

}
