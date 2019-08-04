package com.gxl.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.gxl.bean.Stu;
import com.gxl.service.StuService;
import com.gxl.service.impl.StuServiceImpl;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> map = request.getParameterMap();
		Stu stu = new Stu();
		try {
			BeanUtils.populate(stu, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		StuService service = new StuServiceImpl();
		int i = service.addStu(stu);
		if(i > 0){
			//添加成功
			System.out.println("tianjia 成功");
			request.getRequestDispatcher("/SelectByPageServlet").forward(request, response);
		}else{
			//添加失败
			System.out.println("tianjia 失败");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
