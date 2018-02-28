package cn.com.github;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJavaBean {
  
	@Test
	public void TestJavaBean (){
		ApplicationContext context = new ClassPathXmlApplicationContext("classPath:springmvc.xml");
		
	} 
}
