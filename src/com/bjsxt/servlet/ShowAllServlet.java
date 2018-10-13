package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.bjsxt.util.PageBean;

public class ShowAllServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		
		//实现分页
		/**
		 * 1、首先要获取浏览器传递过来的页码，也就是当前页的索引
		 * 
		 */
		
		//1、处理请求页码
		String sindex = request.getParameter("index");
		int index = 1;//页码默认值为1
		try{
			index = Integer.parseInt(sindex);
		}catch(NumberFormatException e){//处理数值转换异常,防止null或“”的发生
			e.printStackTrace();
		}
		
		String ssize = request.getParameter("size");
		int size = 5;
		try{
			size = Integer.parseInt(ssize);
		}catch(NumberFormatException e){//处理数值转换异常,防止null或“”的发生
			e.printStackTrace();
		}
		
		//获取查询条件
		String name = request.getParameter("name");
		String sminScore = request.getParameter("minScore");
		double minScore = 0;
		try{
			minScore = Double.parseDouble(sminScore);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//调用工具类PageBean
		PageBean<Student> pageBean = new PageBean<Student>();
		//存储分页所需参数属性
		pageBean.setIndex(index);
		pageBean.setSize(size);
		
	
		//调用业务层对象
		  StudentService stuBiz = new StudentServiceImpl();
		//由于要使用分页，所以业务逻辑要重新处理
		//List <Student> stuList =stuBiz.findAll();
		  
		//这里不需要返回数据集合，因为pageBean里面已经拿到了
		//经过业务层的处理，所有数据都在pageBean这里
		//这样做更方便，顺便把分页所需的参数集合全部传到前端
		 stuBiz.findStu(pageBean,name,minScore);
		 request.setAttribute("pageBean",pageBean);//!!!!!!!
		 request.setAttribute("name", name);
		 request.setAttribute("minScore", sminScore);
		 
		//3com.bjsxt
		  
		request.getRequestDispatcher("/jsp/showAll2.jsp").forward(request, response); 
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
