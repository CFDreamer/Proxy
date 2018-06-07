package com.jdk.intceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {
	//��ʵ����
	private Object target=null;
	//��������ȫ�޶���
	private String interceptorClass=null;
	
	public InterceptorJdkProxy(Object target, String interceptorClass) {
		super();
		this.target = target;
		this.interceptorClass = interceptorClass;
	}

	/**
	 * ��ί�ж��󲢷���һ��������ռλ��
	 * 
	 * @param target ��ʵ����
	 * @return �������ռλ
	 */
	public static Object bind(Object target,String interceptorClass){
		//ȡ�ô������
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptorClass));
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
