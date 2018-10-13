package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.util.PageBean;

public class StudentServiceImpl implements StudentService {

	private StudentDao stuDao = new StudentDaoImpl();

	public List<Student> findAll() {
		return this.stuDao.findAll();
	}

	@Override
	public void findStu(PageBean<Student> pageBean) {
		// 查询数据库表获取记录总数,优化查询语句
		// int totalCount = this.stuDao.findAll().size();

		int totalCount = this.stuDao.findCount();
		// 把记录总数传进pageBean中，计算出其他属性的值
		/**
		 * totalCount 根据获取的总记录数值，计算出总页数 totalPageCount 总页数 numbers
		 * 这个属性应该是存储每页显示多少条数据的数组
		 */
		pageBean.setTotalCount(totalCount);

		/*
		 * 注意：oracle数据库的索引从0开始 假设：页码index 每页显示数据size 已知 每页应显示数据库的第几条数据，到第几条数据
		 * size = 5 index start end 1 0 4 2 5 9 3 10 14 根据以上数据，推演出规律
		 * 1、发现end的值总是index的5倍-1 2、发现start的值总比end-4 3、5又是size的值 即：end =
		 * index*size-1 start = end-(size-1)|| index*size-(size-1)
		 */

		// 调用工具类给我们实现好的
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();

		// 获取用户请求页的数据并把其放到pageBean中
		List<Student> list = this.stuDao.findStu(start, end);
		pageBean.setList(list);

	}

	@Override
	public void findStu(PageBean<Student> pageBean, String name, double minScore) {
		// TODO Auto-generated method stub

		//查询符合条件的记录数
		int totalCount = this.stuDao.findCount(name,minScore);
		// 把记录总数传进pageBean中，计算出其他属性的值
		/**
		 * totalCount 根据获取的总记录数值，计算出总页数 totalPageCount 总页数 numbers
		 * 这个属性应该是存储每页显示多少条数据的数组
		 */
		pageBean.setTotalCount(totalCount);

		// 调用工具类给我们实现好的
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();

		// 获取用户请求页的数据并把其放到pageBean中
		List<Student> list = this.stuDao.findStu(start, end,name,minScore);
		pageBean.setList(list);
	}

	@Override
	public int delete(int id) {
		return this.stuDao.delete(id);
	}

}
