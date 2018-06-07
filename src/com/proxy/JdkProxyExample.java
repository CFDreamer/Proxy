package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
	//��ʵ����
	private Object target=null;
	/**
	 * ��������������ʵ����Ķ������ϵ�������ش������
	 * @param target ��ʵ����
	 * @return �������
	 */
	public  Object bind(Object target) {
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("��������߼�����");
		System.out.println("������ʵ����Ǯ�ķ���");
		Object obj=method.invoke(target, args);
		System.out.println("�ڵ�����ʵ����֮��ķ���");
		return obj;
		
	}

}
