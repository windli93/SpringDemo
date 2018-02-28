package cn.com.github.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.com.github.entity.Employees;
import cn.com.github.mapper.EmpMapper;

@RequestMapping("/Items")
public class ItemsController implements Controller {

	@Autowired
	EmpMapper mapper;
    @RequestMapping("/handler")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      BeanFactory
		// 调用mapper的数据
		List<Employees> employees = mapper.findByEmpNo("ss");
		// moderandview
		ModelAndView view = new ModelAndView();
		view.addObject("employees", employees);
		view.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		return view;
	}

}
