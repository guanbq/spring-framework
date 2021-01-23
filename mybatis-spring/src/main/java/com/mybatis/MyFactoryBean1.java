package com.mybatis;

import com.gbq.dao.OrderMapper;
import com.gbq.dao.UserMapper;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryBean1 implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{OrderMapper.class},
		new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName());
				return null;
			}
		});
	}

	@Override
	public Class<?> getObjectType() {
		return OrderMapper.class;
	}
}
