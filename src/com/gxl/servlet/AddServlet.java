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
		//��������
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
			//��ӳɹ�
			System.out.println("tianjia �ɹ�");
			request.getRequestDispatcher("/SelectByPageServlet").forward(request, response);
		}else{
			//���ʧ��
			System.out.println("tianjia ʧ��");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
