package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 告诉springmvc，这个是个控制器
@Controller
public class HelloHandler {
	
	// 处理完成后，转发到success.jsp页面
	// springmvc中转发到哪个页面，只需要将页面的路径直接返回即可
	// 告诉springmvc，此方法是处理hello请求
	@RequestMapping(value="/hello")
	public String handle1() {
		
		System.out.println("处理了hello请求！");
		
		//return "/WEB-INF/pages/success.jsp";
		
		return "success";
		
	}

}
