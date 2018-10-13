package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {
	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	public List<Student> findAll();

	/**
	 * ��ѯָ����Χ��ѧ��
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Student> findStu(int start, int end);

	/**
	 * ��ѯ������
	 * @return
	 */
	public int findCount();

	/**
	 * ��ѯ���������ļ�¼��
	 * @param name
	 * @param minScore
	 * @return
	 */
	public int findCount(String name, double minScore);

	/**
	 * ��ѯ�������������ݣ�����ҳ
	 * @param start
	 * @param end
	 * @param name
	 * @param minScore
	 * @return
	 */
	public List<Student> findStu(int start, int end, String name,
			double minScore);

	/**
	 * ɾ��ѧ��
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
}
