package com.test;


import org.junit.Test;

import com.entity.HelloWorld;
import com.entity.impl.HelloWroldImpl;
import com.proxy.JdkProxyExample;
public class test {
	@Test
	public void test1() {
		JdkProxyExample j=new JdkProxyExample();
		HelloWorld proxy=(HelloWorld)j.bind(new HelloWroldImpl());
		proxy.sayHello();
		proxy.sayUsername("уехЩ");
		}
}
