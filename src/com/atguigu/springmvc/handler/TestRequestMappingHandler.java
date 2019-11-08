package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 1. @RequestMapping标注的位置
 * @RequestMapping可以标注在类和方法上
 * 		方法上：  为当前方法绑定处理的url
 * 		类上: 为当前类的所有标注了@RequestMapping注解的方法，提供一层父路径
 * 				
 * 
 * 	保证： 在同一个项目中，不允许将同一个url映射到不同的标注了@RequestMapping的方法上！
 * 			保证不能出现有相同的@RequestMapping
 * 
 * 2. @RequestMapping的value和method属性
 * 			value： 限制当前方法匹配的url的值
 * 			method:   限制当前方法匹配的url的请求方式。如果不声明，代表没有限制。
 * 						声明后如果url发送的method和声明的不匹配，报错405！
 * 
 * 
 * 
 * 
 */
@RequestMapping(value="/test1")
@Controller
public class TestRequestMappingHandler {
	
	@RequestMapping(value= {"/hello","/hello2"},method= {RequestMethod.GET})
	public String handle1() {
		
		System.out.println("TestRequestMappingHandler处理了hello请求！");
		
		return "success";
		
	}

}
