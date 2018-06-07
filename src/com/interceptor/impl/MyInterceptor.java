package com.interceptor.impl;

import java.lang.reflect.Method;

import com.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("反射方法前的逻辑");
		return false;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("反射方法后的逻辑");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("取代了被代理对象的方法");
		
	}

}
