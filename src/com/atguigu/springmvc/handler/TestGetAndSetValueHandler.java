package com.atguigu.springmvc.handler;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 1. �����й�������
 * 			�Ĵ������
 * 				pageContext / request /session /applicaton
 * 
 * 2.��request�������ݣ�
 * 			javaweb��request.setAttribute("name","value");
 * 			springmvc: 
 * 					���ڴ�������ķ����β�λ������Map/Model/ModelMap���͵Ĳ�����
 * 						springmvc�Զ��Բ�����ʼ����ʹ�ò������������ݣ�
 * 
 * 					�������͵Ĳ������Ὣ���ݷ��뵽request��
 * 					�������͵Ĳ�����ʹ��ͬһ������ʵ�֣��������������ǣ�org.springframework.validation.support.BindingAwareModelMap��
 * 					��������󣬳�Ϊ����ģ��(��Դ��ײ㣬�����������ʱ������ΪimplictModel)��
 * 
 * 					�ڽ���������ķ����ķ���ֵ����ΪModelAndView����
 * 		
 * 
 * 3.���request��session��������
 * 			javaweb��HttpSession.setAttribute("name","value");
 * 
 * 4. ��application��������
 * 			javaweb: ServletContext.setAttribute("name","value");
 */
 @Controller
 @RequestMapping(value="/test4")
public class TestGetAndSetValueHandler {
	 
	 @RequestMapping(value = "/handle1")
	public String handle(Map map,Model model ,ModelMap modelMap) {
		 
		 map.put("map", map.getClass().getName());
		 System.out.println(map==model);
		 model.addAttribute("model", model.getClass().getName());
		 System.out.println(map==modelMap);
		 modelMap.addAttribute("modelMap", modelMap.getClass().getName());
		 
		 

		System.out.println("������handle1����");

		return "success";

	}
	 
	 @RequestMapping(value = "/handle2")
	public ModelAndView handle2() {

		System.out.println("������handle2����");
		
		ModelAndView modelAndView = new ModelAndView();
		
		// ������ͼ������ƴ��
		modelAndView.setViewName("success");
		
		// ���ս����ݷ�������ģ�ͣ�������ģ�ͷ���������
		modelAndView.addObject("modelAndView", "hello!");

		return modelAndView;

	}
	 
	 @RequestMapping(value = "/handle3")
	public String handle3(HttpSession session) {

		System.out.println("������handle3����");
		
		session.setAttribute("session", "session");
		
		ServletContext application = session.getServletContext();
		
		application.setAttribute("application", "application");

		return "success";

	}

}
