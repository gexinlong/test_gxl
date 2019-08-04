package com.gxl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxl.service.StuService;
import com.gxl.service.impl.StuServiceImpl;


public class DelAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//需要删除的id
		String[] ids = request.getParameterValues("cb");
		//调用service 
		StuService service = new StuServiceImpl();
		int i = service.delAll(ids);
		
		if(i>0) {
			response.sendRedirect(request.getContextPath()+"/SelectByPageServlet");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/SelectByPageServlet");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
