package com.interceptor.impl;

import java.lang.reflect.Method;

import com.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("���䷽��ǰ���߼�");
		return false;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub
		System.out.println("���䷽������߼�");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("ȡ���˱��������ķ���");
		
	}

}
