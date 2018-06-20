package com.jdk.intceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.interceptor.Interceptor;

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
	
	//�����߼�
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object obj=null;
		//���û��������������ֱ�ӽ�����ʵ����
		if(null==interceptorClass) {
			return method.invoke(target, args);
		}
		Interceptor inte=(Interceptor) Class.forName(interceptorClass).newInstance();
		if(inte.before(proxy, args, method, args)) {
			obj=method.invoke(target, args);
		}
		else
		{
			inte.around(proxy, args, method, args);
		}
		inte.after(proxy, args, method, args);
		return obj;

	}

}
