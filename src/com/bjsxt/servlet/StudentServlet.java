package com.bjsxt.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.bjsxt.util.PageBean;


public class StudentServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String operate = req.getParameter("operate");
		String sid = req.getParameter("sid");
		String sindex = req.getParameter("index");
		String ssize = req.getParameter("size");
		int id = 0;
		boolean flag = false;
		StudentService ss = new StudentServiceImpl();
		if(operate.equals("preupdate")){
			
		}else if(operate.equals("delete")){
			try{
				id = Integer.parseInt(sid);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(ss.delete(id)>0){
				flag = true;
			}
		}
		String showAll = "/servlet/ShowAllServlet?index="+sindex+"&ssize="+ssize;
		
		//×ª»»
		req.getRequestDispatcher(showAll).forward(req, resp);
	}
}
