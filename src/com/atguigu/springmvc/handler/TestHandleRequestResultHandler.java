package com.atguigu.springmvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.springmvc.bean.Book;

/*
 * 1. 转发
 * 			web:  HttpServletRequest.getRequestDispatcher("url").forward(request,response);
 * 			springmvc:   
 * 					①直接将要转发的页面地址返回即可，返回的页面地址还可以简写，经过视图解析器拼接完成的地址！
 * 
 * 					②可以使用  forward:url 作为方法的返回值
 * 							forward:url的形式，不会再经过视图解析器拼接视图地址，直接转发到指定的页面！
 * 							要求： url必须使用绝对路径！
 * 2. 重定向：  
 * 			web: HttpServletResponse.sendRedirect("url"); 自己手动加上项目名！
 * 
 * 			springmvc:  使用 redirect:url,完成重定向！
 * 						注意：  redirect:url不会经过视图解析器拼接地址！
 * 						要求：  url必须使用绝对路径，可以省略项目名！
 * 
 * 3.使用原生API
 * 			只需要在参数位置声明即可，框架会自动赋值！
 * 			HttpServletRequest request,HttpServletResponse response,HttpSession session
 * 
 * 4. 在java中将数据保存到数据，通常需要使用ORM映射
 * 		ORM（object relational mapping）:  对象关系映射。
 * 				将关系型数据库中的每行，映射为一个java对象！
 * 				每行中的没列，映射为当前这个java对象的一个属性！
 * 				将多行，映射为一个集合！
 * 
 * 5. 如果表单提交的参数过多，可以根据表单提交的参数，声明一个javabean，在处理方法的形参位置，只需要声明一个对应的javabean即可
 * 			表单中的每个参数都会赋值给声明的javabean的对应的属性！
 * 				表单中属性名------>javabean.setXXX()
 * 
 * 		级联属性：  Book[private Address address[String addressNum,String addressLoc]]
 * 				将addressNum和addressLoc 称为 Book对象的级联属性！
 * 
 * 		赋值：  属性.属性
 * 				address.addressNum
 * 
 * 6. POST请求乱码的解决：
 * 			在第一次获取请求参数前，调用HttpServletRequest.setCharacterEncoding("xxx");
 * 			
 * 			解决思路：  使用Filter拦截当前项目的所有请求，将编码更改，更改后，放行到servlet!
 * 			SpringMVC提供了此Filter! CharacterEncodingFilter.
 * 				设置：  CharacterEncodingFilter.encoding="UTF-8";
 * 					CharacterEncodingFilter.forceEncoding=true;
 * 			
 */
@RequestMapping(value="/test3")
@Controller
public class TestHandleRequestResultHandler {
	
	@RequestMapping(value = "/handle1")
	public String handle1() {

		System.out.println("处理了handle1请求！");
		
		// 转发到/success.jsp

		// 不规范
		//return "../../success";
		
		return "forward:/success.jsp";

	}
	
	@RequestMapping(value = "/handle2")
	public String handle2() {

		System.out.println("处理了handle2请求！");

		return "forward:/test3/handle1";

	}
	
	@RequestMapping(value = "/handle3")
	public String handle3() {

		System.out.println("处理了handle3请求！");

		return "redirect:/index.html";

	}
	
	@RequestMapping(value = "/handle4")
	public String handle4() {

		System.out.println("处理了handle4请求！");

		return "redirect:/test3/handle3";

	}
	
	// 希望使用原生API
	@RequestMapping(value = "/handle5")
	public String handle5(HttpServletRequest request,HttpServletResponse response,HttpSession session) {

		System.out.println("处理了handle5请求！");
		
		String username = request.getParameter("username");
		
		session.setAttribute("un", username);

		return "success";

	}
	
	// 将表单中的数据，取出，封装为一个javabean，调用dao将bean保存到数据库
	@RequestMapping(value = "/addBook")
	public String handle6(Book book) {

		System.out.println("处理了addBook请求！接受的图书参数是:"+book);

		return "success";

	}

}
