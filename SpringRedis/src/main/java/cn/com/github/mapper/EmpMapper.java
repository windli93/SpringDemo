package cn.com.github.mapper;

import java.util.List;

import cn.com.github.entity.Employees;

public interface EmpMapper {

	//根据id查询emp_no
	public Employees findEmpById(int emp_no) throws Exception;
    //模糊查询
	public List<Employees> findByEmpNo(String first_name) throws Exception;
	// 添加用户信息
	public void insertEmpNo(Employees emp) throws Exception;
	// 删除用户信息
	public void deleteEmpNo(int emp_no) throws Exception;
	// 更新用户信息
	public void updateEmpNo(Employees emp) throws Exception;
}
