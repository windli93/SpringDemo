package cn.com.github;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.com.github.entity.Salaries;

public class TestMain {
    
       //sqlSession方法
	  public SqlSession getSession() throws Exception {
		  
		  String resource = "mybatis.xml";
		  InputStream stream = Resources.getResourceAsStream(resource);
		  SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
		  SqlSession session = factory.openSession();
		  
		  return session;
	  }
	  
	//  @Test
	  public void findAllSal() throws Exception{
		  
		  String statement = "cn.com.github.salarMapper.findAllSal";
		  SqlSession session = getSession();
		  List<Salaries> salaries = session.selectList(statement);
		  Iterator<Salaries> sIterator = salaries.iterator();
		  System.out.println(salaries.size());
		  while(sIterator.hasNext()) {
			  System.out.println("salaries的东西"+sIterator.next().toString());
		  }
		  session.close();
	  }
	  
	 // @Test
	  public void findAllSalById() throws Exception{
		  
		  String statement = "cn.com.github.salarMapper.findSalById";
		  SqlSession session = getSession();
		  Salaries salaries = new Salaries(10001,0,"1987-06-26",null);
		  salaries = session.selectOne(statement,salaries);
		  System.out.println(salaries.toString());
		  session.close();
	  }
	  
	//  @Test
	  public void insrtSalById() throws Exception{
		  String statement = "cn.com.github.salarMapper.insrtSalById";
		  SqlSession session = getSession();
		  Salaries salaries = new Salaries(10079,4800,"2017-01-04","2015-03-05");
		  int i = session.insert(statement,salaries);
		  if (i > 0) {
			System.out.println("插入成功");
		}else if (i == 0) {
			System.out.println("插入失败");
		}
		  session.commit();
		  session.close();
	  }
}
