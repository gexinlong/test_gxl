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
		//���ղ���
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//������֤��
		String verifycode = request.getParameter("verifycode");
		//��������������֤��
		String checkCode = (String)request.getSession().getAttribute("CHECKCODE_SERVER");
		//�ж�������֤���Ƿ�һ��
		if(verifycode.equalsIgnoreCase(checkCode)){
			//��֤��һ��  ���ж��û���������
			Log log = new Log();
			log.setUsername(username);
			log.setPassword(password);
			StuService service = new StuServiceImpl();
			Log log2 = service.loginStu(log);
			if(log2 != null){
				//�û���������ȷ
				request.getSession().setAttribute("log", log2);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else{
				//�û������벻��ȷ ����������ʾ
				request.setAttribute("login_msg", "�û������������");
				//������¼ҳ��
				request.getRequestDispatcher("/login.jsp").forward(request, response);			}
			
			
		}else{
			//��֤�벻һ��  ������¼ҳ��   ����������ʾ
			request.setAttribute("login_msg", "��֤�����");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
