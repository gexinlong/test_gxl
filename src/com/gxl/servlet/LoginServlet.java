package com.gxl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxl.bean.Log;
import com.gxl.service.StuService;
import com.gxl.service.impl.StuServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//接收验证码
		String verifycode = request.getParameter("verifycode");
		//服务器产生的验证码
		String checkCode = (String)request.getSession().getAttribute("CHECKCODE_SERVER");
		//判断两个验证吗是否一样
		if(verifycode.equalsIgnoreCase(checkCode)){
			//验证码一样  在判断用户名和密码
			Log log = new Log();
			log.setUsername(username);
			log.setPassword(password);
			StuService service = new StuServiceImpl();
			Log log2 = service.loginStu(log);
			if(log2 != null){
				//用户名密码正确
				request.getSession().setAttribute("log", log2);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else{
				//用户名密码不正确 给出错误提示
				request.setAttribute("login_msg", "用户名或密码错误");
				//跳到登录页面
				request.getRequestDispatcher("/login.jsp").forward(request, response);			}
			
			
		}else{
			//验证码不一样  跳到登录页面   给出错误提示
			request.setAttribute("login_msg", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
