package com.atguigu.springmvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.springmvc.bean.Book;

/*
 * 1. ת��
 * 			web:  HttpServletRequest.getRequestDispatcher("url").forward(request,response);
 * 			springmvc:   
 * 					��ֱ�ӽ�Ҫת����ҳ���ַ���ؼ��ɣ����ص�ҳ���ַ�����Լ�д��������ͼ������ƴ����ɵĵ�ַ��
 * 
 * 					�ڿ���ʹ��  forward:url ��Ϊ�����ķ���ֵ
 * 							forward:url����ʽ�������پ�����ͼ������ƴ����ͼ��ַ��ֱ��ת����ָ����ҳ�棡
 * 							Ҫ�� url����ʹ�þ���·����
 * 2. �ض���  
 * 			web: HttpServletResponse.sendRedirect("url"); �Լ��ֶ�������Ŀ����
 * 
 * 			springmvc:  ʹ�� redirect:url,����ض���
 * 						ע�⣺  redirect:url���ᾭ����ͼ������ƴ�ӵ�ַ��
 * 						Ҫ��  url����ʹ�þ���·��������ʡ����Ŀ����
 * 
 * 3.ʹ��ԭ��API
 * 			ֻ��Ҫ�ڲ���λ���������ɣ���ܻ��Զ���ֵ��
 * 			HttpServletRequest request,HttpServletResponse response,HttpSession session
 * 
 * 4. ��java�н����ݱ��浽���ݣ�ͨ����Ҫʹ��ORMӳ��
 * 		ORM��object relational mapping��:  �����ϵӳ�䡣
 * 				����ϵ�����ݿ��е�ÿ�У�ӳ��Ϊһ��java����
 * 				ÿ���е�û�У�ӳ��Ϊ��ǰ���java�����һ�����ԣ�
 * 				�����У�ӳ��Ϊһ�����ϣ�
 * 
 * 5. ������ύ�Ĳ������࣬���Ը��ݱ��ύ�Ĳ���������һ��javabean���ڴ��������β�λ�ã�ֻ��Ҫ����һ����Ӧ��javabean����
 * 			���е�ÿ���������ḳֵ��������javabean�Ķ�Ӧ�����ԣ�
 * 				����������------>javabean.setXXX()
 * 
 * 		�������ԣ�  Book[private Address address[String addressNum,String addressLoc]]
 * 				��addressNum��addressLoc ��Ϊ Book����ļ������ԣ�
 * 
 * 		��ֵ��  ����.����
 * 				address.addressNum
 * 
 * 6. POST��������Ľ����
 * 			�ڵ�һ�λ�ȡ�������ǰ������HttpServletRequest.setCharacterEncoding("xxx");
 * 			
 * 			���˼·��  ʹ��Filter���ص�ǰ��Ŀ���������󣬽�������ģ����ĺ󣬷��е�servlet!
 * 			SpringMVC�ṩ�˴�Filter! CharacterEncodingFilter.
 * 				���ã�  CharacterEncodingFilter.encoding="UTF-8";
 * 					CharacterEncodingFilter.forceEncoding=true;
 * 			
 */
@RequestMapping(value="/test3")
@Controller
public class TestHandleRequestResultHandler {
	
	@RequestMapping(value = "/handle1")
	public String handle1() {

		System.out.println("������handle1����");
		
		// ת����/success.jsp

		// ���淶
		//return "../../success";
		
		return "forward:/success.jsp";

	}
	
	@RequestMapping(value = "/handle2")
	public String handle2() {

		System.out.println("������handle2����");

		return "forward:/test3/handle1";

	}
	
	@RequestMapping(value = "/handle3")
	public String handle3() {

		System.out.println("������handle3����");

		return "redirect:/index.html";

	}
	
	@RequestMapping(value = "/handle4")
	public String handle4() {

		System.out.println("������handle4����");

		return "redirect:/test3/handle3";

	}
	
	// ϣ��ʹ��ԭ��API
	@RequestMapping(value = "/handle5")
	public String handle5(HttpServletRequest request,HttpServletResponse response,HttpSession session) {

		System.out.println("������handle5����");
		
		String username = request.getParameter("username");
		
		session.setAttribute("un", username);

		return "success";

	}
	
	// �����е����ݣ�ȡ������װΪһ��javabean������dao��bean���浽���ݿ�
	@RequestMapping(value = "/addBook")
	public String handle6(Book book) {

		System.out.println("������addBook���󣡽��ܵ�ͼ�������:"+book);

		return "success";

	}

}
