package com.gxl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxl.service.StuService;
import com.gxl.service.impl.StuServiceImpl;

public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ÐèÒªÉ¾³ýµÄid
		String id = request.getParameter("id");
		StuService service = new StuServiceImpl();
		int num = service.delStu(id);
		if(num > 0){
			System.out.println("//É¾³ý³É¹¦");
			request.getRequestDispatcher("/SelectByPageServlet").forward(request, response);
		}else{
			//É¾³ýÊ§°Ü
			System.out.println("//É¾³ýÊ§°Ü");
			request.getRequestDispatcher("/SelectByPageServlet").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
