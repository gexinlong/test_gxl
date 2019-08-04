package com.gxl.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gxl.bean.Log;
import com.gxl.bean.Stu;
import com.gxl.dao.StuDao;
import com.gxl.util.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class StuDaoImpl implements StuDao {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	//登录
	@Override
	public Log loginStu(Log log) {
		try {
			String sql = "select * from log where username = ? and password = ?";
			Object[] params = {log.getUsername(),log.getPassword()};
			return qr.query(sql, new BeanHandler<Log>(Log.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	//总记录数
	@Override
	public int selectCount() {
		try {
			String sql = "select count(*) from stu,classes where stu.cid = classes.cid ";
			return qr.query(sql, new ScalarHandler<Long>()).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	//每页显示的具体数据
	@Override
	public List<Stu> selectStuByPage(int start, int rows) {
		try {
			String sql = "select  stu.*,classes.* from stu , classes  where stu.cid = classes.cid ";
			return qr.query(sql, new BeanListHandler<Stu>(Stu.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	//找到修改的数据
	@Override
	public Stu findStu(int id) {
		try {
			String sql = "select stu.*,classes.* from stu,classes where stu.cid = classes.cid and stu.id = ?";
			return qr.query(sql, new BeanHandler<Stu>(Stu.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	//修改
	@Override
	public int updateStu(Stu stu) {
		try {
			String sql = "update stu,classes set xuehao = ?,name = ?,sex = ?,age = ?,cname = ? where stu.cid = classes.cid and stu.id = ?";
			Object[] params = {stu.getXuehao(),stu.getName(),stu.getSex(),stu.getAge(),stu.getCname(),stu.getId()};
			return qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	//删除
	@Override
	public int delStu(int id) {
		String sql = "delete from stu where id = ?";
		int num = 0;
		try {
			 num = qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	//添加
	@Override
	public int addStu(Stu stu) {
		String sql1 = "insert into classes values(?,?)";
		String sql2 = "insert into stu values(0,?,?,?,?,(select cid from classes where cname = ?))";
		Object[] params = {stu.getXuehao(),stu.getName(),stu.getSex(),stu.getAge(),stu.getCname()};
		try {
			int n = qr.update(sql1,stu.getCid(), stu.getCname());
			int m = qr.update(sql2, params);
			return m + n;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
