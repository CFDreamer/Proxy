package com.jdk.intceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.interceptor.Interceptor;

public class InterceptorJdkProxy implements InvocationHandler {
	//真实对象
	private Object target=null;
	//拦截器的全限定名
	private String interceptorClass=null;
	
	public InterceptorJdkProxy(Object target, String interceptorClass) {
		super();
		this.target = target;
		this.interceptorClass = interceptorClass;
	}

	/**
	 * 绑定委托对象并返回一个【代理占位】
	 * 
	 * @param target 真实对象
	 * @return 代理对象占位
	 */
	public static Object bind(Object target,String interceptorClass){
		//取得代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptorClass));
	}
	
	//代理逻辑
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object obj=null;
		//如果没有设置拦截器，直接进入真实方法
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
