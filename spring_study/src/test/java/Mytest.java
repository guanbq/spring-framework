import com.gbq.config.AppApplication;
import com.gbq.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mytest {
	@Test
	public void test(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppApplication.class);
		User user = applicationContext.getBean("user", User.class);
	}
}
