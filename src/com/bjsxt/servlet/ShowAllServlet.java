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
		//�����������
		request.setCharacterEncoding("utf-8");
		
		//ʵ�ַ�ҳ
		/**
		 * 1������Ҫ��ȡ��������ݹ�����ҳ�룬Ҳ���ǵ�ǰҳ������
		 * 
		 */
		
		//1����������ҳ��
		String sindex = request.getParameter("index");
		int index = 1;//ҳ��Ĭ��ֵΪ1
		try{
			index = Integer.parseInt(sindex);
		}catch(NumberFormatException e){//������ֵת���쳣,��ֹnull�򡰡��ķ���
			e.printStackTrace();
		}
		
		String ssize = request.getParameter("size");
		int size = 5;
		try{
			size = Integer.parseInt(ssize);
		}catch(NumberFormatException e){//������ֵת���쳣,��ֹnull�򡰡��ķ���
			e.printStackTrace();
		}
		
		//��ȡ��ѯ����
		String name = request.getParameter("name");
		String sminScore = request.getParameter("minScore");
		double minScore = 0;
		try{
			minScore = Double.parseDouble(sminScore);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//���ù�����PageBean
		PageBean<Student> pageBean = new PageBean<Student>();
		//�洢��ҳ�����������
		pageBean.setIndex(index);
		pageBean.setSize(size);
		
	
		//����ҵ������
		  StudentService stuBiz = new StudentServiceImpl();
		//����Ҫʹ�÷�ҳ������ҵ���߼�Ҫ���´���
		//List <Student> stuList =stuBiz.findAll();
		  
		//���ﲻ��Ҫ�������ݼ��ϣ���ΪpageBean�����Ѿ��õ���
		//����ҵ���Ĵ����������ݶ���pageBean����
		//�����������㣬˳��ѷ�ҳ����Ĳ�������ȫ������ǰ��
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
