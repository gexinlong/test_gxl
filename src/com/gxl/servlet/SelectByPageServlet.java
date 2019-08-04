package com.gxl.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxl.bean.PageBean;
import com.gxl.bean.Stu;
import com.gxl.service.StuService;
import com.gxl.service.impl.StuServiceImpl;

public class SelectByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String currentPage = request.getParameter("currentPage");
		String rows = request.getParameter("rows");
		//当前页和rows是否为空
		if(currentPage == null || "".equals(currentPage)){
			currentPage ="1";
		}
		
		if(rows == null || "".equals(rows)){
			rows ="5";
		}
		Stu stu = new Stu();
		//Map<String, String[]> map = request.getParameterMap();
		//调用service层方法
		StuService service = new StuServiceImpl();
		PageBean<Stu> pb = service.selectByPage(currentPage,rows);
		//把查到的数据放到域中
		request.setAttribute("pb",pb);
		//request.setAttribute("map",map);
		//跳到list.jsp
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
