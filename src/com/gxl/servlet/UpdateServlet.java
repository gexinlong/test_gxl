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

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("tetx/html;charset=utf-8");
		//�����޸ĵĲ���
		Map<String, String[]> map = request.getParameterMap();
		Stu stu = new Stu();
		try {
			BeanUtils.populate(stu,map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(stu);
		//����service�㷽��
		StuService service = new StuServiceImpl();
		int num = service.updateStu(stu);
		if(num >0){
			//�޸ĳɹ�
			System.out.println("�ɹ�");
			request.getRequestDispatcher("/SelectByPageServlet").forward(request, response);
		}else{
			//�޸�ʧ��
			System.out.println("ʧ��");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
