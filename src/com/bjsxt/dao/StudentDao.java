package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> findAll();

	/**
	 * 查询指定范围的学生
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Student> findStu(int start, int end);

	/**
	 * 查询总条数
	 * @return
	 */
	public int findCount();

	/**
	 * 查询符合条件的记录数
	 * @param name
	 * @param minScore
	 * @return
	 */
	public int findCount(String name, double minScore);

	/**
	 * 查询符合条件的数据，带分页
	 * @param start
	 * @param end
	 * @param name
	 * @param minScore
	 * @return
	 */
	public List<Student> findStu(int start, int end, String name,
			double minScore);

	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
}
