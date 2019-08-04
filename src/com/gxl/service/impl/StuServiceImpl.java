package com.gxl.service.impl;

import java.util.List;
import java.util.Map;

import com.gxl.bean.Log;
import com.gxl.bean.PageBean;
import com.gxl.bean.Stu;
import com.gxl.dao.StuDao;
import com.gxl.dao.impl.StuDaoImpl;
import com.gxl.service.StuService;

public class StuServiceImpl implements StuService {
	StuDao dao = new StuDaoImpl();

	//��¼
	@Override
	public Log loginStu(Log log) {
		return dao.loginStu(log);
	}

	//��ҳ��ѯ
	@Override
	public PageBean<Stu> selectByPage(String currentPage, String rowss) {
		PageBean<Stu> pageBean = new PageBean<Stu>();
		//תΪ����
		int current = Integer.parseInt(currentPage);
		if(current <= 0){
			current = 1;
		}
		int rows = Integer.parseInt(rowss);
		pageBean.setCurrentPage(current);
		pageBean.setRows(rows);
		
		//�ܼ�¼��
		int totalCount = dao.selectCount();
		pageBean.setTotalCount(totalCount);
		
		//��ҳ��
		int totalPage = totalCount%rows== 0 ? totalCount/rows : totalCount/rows+1;
		pageBean.setTotalPage(totalPage);
		
		//ÿҳ��ʾ�ľ�������
		int start = (current - 1)*rows;
		List<Stu> list = dao.selectStuByPage(start,rows);
		pageBean.setList(list);
		return pageBean;
	}

	//�ҵ��޸ĵ�����
	@Override
	public Stu findStu(String idStu) {
		int id = Integer.parseInt(idStu);
		return dao.findStu(id);
		
	}

	//�޸�
	@Override
	public int updateStu(Stu stu) {
		return dao.updateStu(stu);
	}

	//ɾ��
	@Override
	public int delStu(String idStu) {
		int id = Integer.parseInt(idStu);
		return dao.delStu(id);
	}

	//���
	@Override
	public int addStu(Stu stu) {
		return dao.addStu(stu);
	}

	//ɾ��ѡ��
	@Override
	public int delAll(String[] ids) {
		int count = 0;
		for (String strId : ids) {
			int id = Integer.parseInt(strId);
			 count += dao.delStu(id);
		}
		return count;
	}

}
