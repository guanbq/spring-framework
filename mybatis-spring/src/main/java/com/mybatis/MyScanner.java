package com.mybatis;

import com.gbq.dao.UserMapper;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

public class MyScanner extends ClassPathBeanDefinitionScanner {
	public MyScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public int scan(String... basePackages) {
		return  super.scan(basePackages);
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			// 遍历修改beanDefinition为自己的factoryBean
			GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
			ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
			constructorArgumentValues.addIndexedArgumentValue(0, beanDefinition.getBeanClassName());
			// 修改属性注入为按类型注入。@Autowired  将会先按类型再按名称
			beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
			beanDefinition.setBeanClass(MyFactoryBean.class);
		}
		return beanDefinitionHolders;
	}

	@Override
	protected boolean isCandidateComponent(MetadataReader metadataReader) {
		return metadataReader.getClassMetadata().isInterface();
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface();
	}
}
