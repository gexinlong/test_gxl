package com.gxl.dao;

import java.util.List;
import java.util.Map;

import com.gxl.bean.Log;
import com.gxl.bean.Stu;

public interface StuDao {

	//��¼
	Log loginStu(Log log);

	//�ܼ�¼��
	int selectCount();

	//ÿҳ��ʾ�ľ�������
	List<Stu> selectStuByPage(int start, int rows);

	//�ҵ��޸ĵ�����
	Stu findStu(int id);

	//�޸�
	int updateStu(Stu stu);
	
	//ɾ��
    int delStu(int id);

    //���
	int addStu(Stu stu);

	

}
