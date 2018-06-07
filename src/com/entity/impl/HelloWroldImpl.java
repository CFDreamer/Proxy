package com.entity.impl;

import com.entity.HelloWorld;

public class HelloWroldImpl implements HelloWorld{

	@Override
	public void sayHello() {
		System.out.println("Hello World");
		
	}

	@Override
	public void sayUsername(String userName) {
		
		System.out.println("userName");
	}

}
