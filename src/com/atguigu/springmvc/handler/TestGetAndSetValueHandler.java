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
 * 1. 在域中共享数据
 * 			四大域对象：
 * 				pageContext / request /session /applicaton
 * 
 * 2.在request域共享数据：
 * 			javaweb：request.setAttribute("name","value");
 * 			springmvc: 
 * 					①在处理请求的方法形参位置声明Map/Model/ModelMap类型的参数！
 * 						springmvc自动对参数初始化，使用参数来共享数据！
 * 
 * 					三种类型的参数都会将数据放入到request域！
 * 					三种类型的参数都使用同一个对象实现，这个对象的类型是：org.springframework.validation.support.BindingAwareModelMap！
 * 					将这个对象，称为隐含模型(在源码底层，声明这个参数时，命名为implictModel)！
 * 
 * 					②将处理请求的方法的返回值声明为ModelAndView类型
 * 		
 * 
 * 3.多个request在session域共享数据
 * 			javaweb：HttpSession.setAttribute("name","value");
 * 
 * 4. 向application域共享数据
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
		 
		 

		System.out.println("处理了handle1请求！");

		return "success";

	}
	 
	 @RequestMapping(value = "/handle2")
	public ModelAndView handle2() {

		System.out.println("处理了handle2请求！");
		
		ModelAndView modelAndView = new ModelAndView();
		
		// 经过视图解析器拼接
		modelAndView.setViewName("success");
		
		// 最终将数据放入隐含模型，由隐含模型放入请求域
		modelAndView.addObject("modelAndView", "hello!");

		return modelAndView;

	}
	 
	 @RequestMapping(value = "/handle3")
	public String handle3(HttpSession session) {

		System.out.println("处理了handle3请求！");
		
		session.setAttribute("session", "session");
		
		ServletContext application = session.getServletContext();
		
		application.setAttribute("application", "application");

		return "success";

	}

}
