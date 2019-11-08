package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 处理请求时，通常的操作
 * 
 * 1.获取请求参数
 * 		web：  HttpServletRequest.getParameter("参数名");
 * 		springmvc:  在处理方法的参数位置声明对应的形参来接受页面的参数即可！
 * 
 * 			注意：使用此种方式，必须保证形参名需和请求参数名一致！否则无法赋值，就为null!
 * 
 * 		如果方法的形参名和请求参数名不一致，需要使用@RequestParam(value="pw")显示绑定参数！
 * 
 * @RequestParam：
 * 		value:  绑定的请求参数名
 * 		required:  代表当前的参数是否是必须的，默认为true。要求url中必须携带此参数，否则就报错400
 * 		defaultValue: 如果没有携带此参数，使用默认值作为参数值！
 * 	    
 * 
 * 2.获取指定请求头对应的value
 * 		web:HttpServletRequest.getHeader(String name)
 * 
 * 		springmvc： @RequestHeader
 * 
 * 3.获取指定cookie对应的value
 * 		web：Cookie [] cookies=HttpServletRequest.getCookies();
 * 
 * 		for(){
 * 				if(Cookie.getName()=="xxxx"){
 * 					Cookie.getValue();
 * 
 * 				}
 * 		}
 * 
 * 		springmvc: @CookieValue
 * 		
 */
@RequestMapping(value = "/test2")
@Controller
public class TestHandleRequestHandler {
	
	@RequestMapping(value = "/handle1")
	public String handle(String username,@RequestParam(value="pw",required=false,defaultValue="123123")Integer password,
			@RequestHeader(value="User-Agent")String userAgent,@CookieValue(value="JSESSIONID")String jesssionidValue) {

		System.out.println("处理了handle1请求！");
		
		System.out.println(username+":"+password);
		
		System.out.println("User-Agent:"+userAgent);
		
		System.out.println("JSESSIONID"+jesssionidValue);

		return "success";

	}

}
