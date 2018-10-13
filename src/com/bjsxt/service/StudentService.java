package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Student;
import com.bjsxt.util.PageBean;

public interface StudentService {

	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	public List<Student> findAll();
	/**
	 * ��ɻ����ķ�ҳ������������ѯ����
	 * @param pageBean
	 */
	public void findStu(PageBean<Student> pageBean);
	
	/**
	 * ʵ�ִ������ķ�ҳ����
	 * @param pageBean
	 * @param name
	 * @param minScore
	 */
	public void findStu(PageBean<Student> pageBean, String name, double minScore);
	/**
	 * ɾ��ѧ��
	 * @param id
	 * @return
	 */
	public int delete(int id);
	

}
