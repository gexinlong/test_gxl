package com.gxl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxl.bean.Stu;
import com.gxl.service.StuService;
import com.gxl.service.impl.StuServiceImpl;

public class FindStuUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收修改的id
		String id = request.getParameter("id");
		//调用servicec方法
		StuService service = new StuServiceImpl();
		Stu stu = service.findStu(id);
		//放到域中
		request.setAttribute("stu", stu);
		//跳到update.jsp
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
