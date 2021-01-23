package com.mybatis;

import com.gbq.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryBean implements FactoryBean {

	private Class mapperClass;

	private SqlSession sqlSession;

	public MyFactoryBean(Class mapperClass) {
		this.mapperClass = mapperClass;
	}

	public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
		this.sqlSession = sqlSessionFactory.openSession();
	}

	@Override
	public Object getObject() throws Exception {
		//修改为mybatis的获取mapper
		return sqlSession.getMapper(mapperClass);

		// return Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{mapperClass},
		// new InvocationHandler() {
		// 	@Override
		// 	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 		System.out.println(method.getName());
		// 		return null;
		// 	}
		// });
	}

	@Override
	public Class<?> getObjectType() {
		return mapperClass;
	}
}
