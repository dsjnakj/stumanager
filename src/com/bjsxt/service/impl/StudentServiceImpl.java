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
		// ��ѯ���ݿ���ȡ��¼����,�Ż���ѯ���
		// int totalCount = this.stuDao.findAll().size();

		int totalCount = this.stuDao.findCount();
		// �Ѽ�¼��������pageBean�У�������������Ե�ֵ
		/**
		 * totalCount ���ݻ�ȡ���ܼ�¼��ֵ���������ҳ�� totalPageCount ��ҳ�� numbers
		 * �������Ӧ���Ǵ洢ÿҳ��ʾ���������ݵ�����
		 */
		pageBean.setTotalCount(totalCount);

		/*
		 * ע�⣺oracle���ݿ��������0��ʼ ���裺ҳ��index ÿҳ��ʾ����size ��֪ ÿҳӦ��ʾ���ݿ�ĵڼ������ݣ����ڼ�������
		 * size = 5 index start end 1 0 4 2 5 9 3 10 14 �����������ݣ����ݳ�����
		 * 1������end��ֵ����index��5��-1 2������start��ֵ�ܱ�end-4 3��5����size��ֵ ����end =
		 * index*size-1 start = end-(size-1)|| index*size-(size-1)
		 */

		// ���ù����������ʵ�ֺõ�
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();

		// ��ȡ�û�����ҳ�����ݲ�����ŵ�pageBean��
		List<Student> list = this.stuDao.findStu(start, end);
		pageBean.setList(list);

	}

	@Override
	public void findStu(PageBean<Student> pageBean, String name, double minScore) {
		// TODO Auto-generated method stub

		//��ѯ���������ļ�¼��
		int totalCount = this.stuDao.findCount(name,minScore);
		// �Ѽ�¼��������pageBean�У�������������Ե�ֵ
		/**
		 * totalCount ���ݻ�ȡ���ܼ�¼��ֵ���������ҳ�� totalPageCount ��ҳ�� numbers
		 * �������Ӧ���Ǵ洢ÿҳ��ʾ���������ݵ�����
		 */
		pageBean.setTotalCount(totalCount);

		// ���ù����������ʵ�ֺõ�
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();

		// ��ȡ�û�����ҳ�����ݲ�����ŵ�pageBean��
		List<Student> list = this.stuDao.findStu(start, end,name,minScore);
		pageBean.setList(list);
	}

	@Override
	public int delete(int id) {
		return this.stuDao.delete(id);
	}

}
