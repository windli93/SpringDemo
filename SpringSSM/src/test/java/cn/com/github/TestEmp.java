package cn.com.github;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.com.github.entity.Employees;
import cn.com.github.mapper.EmpMapper;

public class TestEmp {

	
	 //sqlSession方法
	  public SqlSession getSession() throws Exception {
		  
		  String resource = "mybatis.xml";
		  InputStream stream = Resources.getResourceAsStream(resource);
		  SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
		  SqlSession session = factory.openSession();
		  
		  return session;
	  }
	  
	 // @Test
	  public void findEmpById () throws Exception{
		  SqlSession session = getSession();
		  EmpMapper mapper = session.getMapper(EmpMapper.class);
		  Employees employees = mapper.findEmpById(10001);
		  System.out.println(employees.toString());
	  }
	  
	  @Test
	  public void findByEmpNo () throws Exception{
		  SqlSession session = getSession();
		  EmpMapper mapper = session.getMapper(EmpMapper.class);
		  List<Employees> employees = mapper.findByEmpNo("s");
		  System.out.println(employees.toString());
	  }
}
