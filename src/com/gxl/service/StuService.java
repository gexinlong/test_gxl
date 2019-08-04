package com.gxl.service;

import java.util.Map;

import com.gxl.bean.Log;
import com.gxl.bean.PageBean;
import com.gxl.bean.Stu;

public interface StuService {

	//��¼
	Log loginStu(Log log);

	//��ҳ��ѯ
	PageBean<Stu> selectByPage(String currentPage, String rows);

	//�ҵ��޸ĵ�����
	Stu findStu(String id);

	//�޸�
	int updateStu(Stu stu);

	//ɾ��
	int delStu(String id);

	//���
	int addStu(Stu stu);

	//ɾ��ѡ��
	int delAll(String[] ids);

}
