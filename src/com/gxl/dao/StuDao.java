package com.gxl.dao;

import java.util.List;
import java.util.Map;

import com.gxl.bean.Log;
import com.gxl.bean.Stu;

public interface StuDao {

	//登录
	Log loginStu(Log log);

	//总记录数
	int selectCount();

	//每页显示的具体数据
	List<Stu> selectStuByPage(int start, int rows);

	//找到修改的数据
	Stu findStu(int id);

	//修改
	int updateStu(Stu stu);
	
	//删除
    int delStu(int id);

    //添加
	int addStu(Stu stu);

	

}
