package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Student;
import com.bjsxt.util.PageBean;

public interface StudentService {

	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> findAll();
	/**
	 * 完成基本的分页操作，不带查询条件
	 * @param pageBean
	 */
	public void findStu(PageBean<Student> pageBean);
	
	/**
	 * 实现带条件的分页操作
	 * @param pageBean
	 * @param name
	 * @param minScore
	 */
	public void findStu(PageBean<Student> pageBean, String name, double minScore);
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	public int delete(int id);
	

}
