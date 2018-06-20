package com.test;

import org.junit.Test;

import com.entity.HelloWorld;
import com.entity.impl.HelloWroldImpl;
import com.jdk.intceptor.InterceptorJdkProxy;

public class Test1 {
	@Test
	public void test() {
		/*Object target=null;
		Object interceptorClass=null;
		InterceptorJdkProxy inter=new InterceptorJdkProxy(target, interceptorClass);*/
		HelloWorld hello=(HelloWorld) InterceptorJdkProxy.bind(new HelloWroldImpl(), "com.interceptor.impl.MyInterceptor");
		hello.sayHello();
	}
}
