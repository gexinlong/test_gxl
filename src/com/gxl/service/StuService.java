package com.gxl.service;

import java.util.Map;

import com.gxl.bean.Log;
import com.gxl.bean.PageBean;
import com.gxl.bean.Stu;

public interface StuService {

	//登录
	Log loginStu(Log log);

	//分页查询
	PageBean<Stu> selectByPage(String currentPage, String rows);

	//找到修改的数据
	Stu findStu(String id);

	//修改
	int updateStu(Stu stu);

	//删除
	int delStu(String id);

	//添加
	int addStu(Stu stu);

	//删除选中
	int delAll(String[] ids);

}
