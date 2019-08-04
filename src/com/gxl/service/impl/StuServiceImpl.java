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

	//登录
	@Override
	public Log loginStu(Log log) {
		return dao.loginStu(log);
	}

	//分页查询
	@Override
	public PageBean<Stu> selectByPage(String currentPage, String rowss) {
		PageBean<Stu> pageBean = new PageBean<Stu>();
		//转为整型
		int current = Integer.parseInt(currentPage);
		if(current <= 0){
			current = 1;
		}
		int rows = Integer.parseInt(rowss);
		pageBean.setCurrentPage(current);
		pageBean.setRows(rows);
		
		//总记录数
		int totalCount = dao.selectCount();
		pageBean.setTotalCount(totalCount);
		
		//总页数
		int totalPage = totalCount%rows== 0 ? totalCount/rows : totalCount/rows+1;
		pageBean.setTotalPage(totalPage);
		
		//每页显示的具体数据
		int start = (current - 1)*rows;
		List<Stu> list = dao.selectStuByPage(start,rows);
		pageBean.setList(list);
		return pageBean;
	}

	//找到修改的数据
	@Override
	public Stu findStu(String idStu) {
		int id = Integer.parseInt(idStu);
		return dao.findStu(id);
		
	}

	//修改
	@Override
	public int updateStu(Stu stu) {
		return dao.updateStu(stu);
	}

	//删除
	@Override
	public int delStu(String idStu) {
		int id = Integer.parseInt(idStu);
		return dao.delStu(id);
	}

	//添加
	@Override
	public int addStu(Stu stu) {
		return dao.addStu(stu);
	}

	//删除选中
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
