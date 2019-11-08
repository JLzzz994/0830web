package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springmvc.bean.Address;
import com.atguigu.springmvc.bean.Book;

/*
 * 1.后台将数据以json形式响应页面
 * 			jackson:  springmvc天然提供了对jackson框架的适配！
 */
@RequestMapping("/test5")
@Controller
public class TestReponseViewHandler {
	
	@RequestMapping(value = "/handle1")
	// 当前方法的返回值会被放入响应体！
	@ResponseBody
	public String handle() {

		System.out.println("处理了handle1请求！");

		// 响应浏览器一个success
		// HttpServletResponse.getwriter.print("success");
		return "success";

	}
	
	@RequestMapping(value = "/handle2",produces="text/html;charset=utf-8")
	// 当前方法的返回值会被放入响应体！
	@ResponseBody
	public String handle2() {

		System.out.println("处理了handle2请求！");

		// 响应浏览器一个success
		// HttpServletResponse.getwriter.print("success");
		return "成功！";

	}
	
	@RequestMapping(value = "/handle3")
	// 当前方法的返回值会被放入响应体！
	@ResponseBody
	public Book handle3() {

		System.out.println("处理了handle3请求！");

		Book book = new Book();
		
		book.setAuthor("吴承恩");
		book.setBookName("《西游记》");
		book.setPrice(888.8);
		book.setAddress(new Address("001", "xx省xx市"));
		// springmvc会自动将java对象转为jsonstr，再响应
		return book;

	}
	
	@RequestMapping(value = "/handle4")
	@ResponseBody
	public String handle4(@RequestBody Book book) {

		System.out.println("处理了handle4请求！");
		
		System.out.println(book);

		return "success";

	}

}
