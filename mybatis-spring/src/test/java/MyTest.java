import com.gbq.config.AppConfig;
import com.gbq.dao.OrderMapper;
import com.gbq.dao.UserMapper;
import com.gbq.service.UserServiceImpl;
import com.mybatis.MyFactoryBean;
import com.mybatis.MyFactoryBean1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {

	@Test
	public void mybatis_test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			System.out.println(mapper.selectUser());
		}
	}

	@Test
	public void mybatis_my() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();


		UserServiceImpl userServiceImpl = context.getBean(UserServiceImpl.class);
		System.out.println(userServiceImpl.selectUser());
	}
}
