package com.mybatis;

import com.gbq.dao.OrderMapper;
import com.gbq.dao.UserMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 通过扫描获取mapper
		String path = "com.gbq.dao";
		MyScanner myScanner = new MyScanner(registry);
		myScanner.scan(path);


		// // 定义factorybean.并注册到beandefination
		// BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
		// BeanDefinition beanDefinition = builder.getBeanDefinition();
		// ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
		// constructorArgumentValues.addIndexedArgumentValue(0, UserMapper.class);
		// registry.registerBeanDefinition("user1", beanDefinition);
		//
		// BeanDefinitionBuilder builder1 = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
		// BeanDefinition beanDefinition1 = builder1.getBeanDefinition();
		// ConstructorArgumentValues constructorArgumentValues1 = beanDefinition1.getConstructorArgumentValues();
		// constructorArgumentValues1.addIndexedArgumentValue(0, OrderMapper.class);
		// registry.registerBeanDefinition("user11", beanDefinition1);
	}
}
