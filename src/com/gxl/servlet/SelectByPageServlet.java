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
		//���ղ���
		String currentPage = request.getParameter("currentPage");
		String rows = request.getParameter("rows");
		//��ǰҳ��rows�Ƿ�Ϊ��
		if(currentPage == null || "".equals(currentPage)){
			currentPage ="1";
		}
		
		if(rows == null || "".equals(rows)){
			rows ="5";
		}
		Stu stu = new Stu();
		//Map<String, String[]> map = request.getParameterMap();
		//����service�㷽��
		StuService service = new StuServiceImpl();
		PageBean<Stu> pb = service.selectByPage(currentPage,rows);
		//�Ѳ鵽�����ݷŵ�����
		request.setAttribute("pb",pb);
		//request.setAttribute("map",map);
		//����list.jsp
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
