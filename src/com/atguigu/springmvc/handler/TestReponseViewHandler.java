package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springmvc.bean.Address;
import com.atguigu.springmvc.bean.Book;

/*
 * 1.��̨��������json��ʽ��Ӧҳ��
 * 			jackson:  springmvc��Ȼ�ṩ�˶�jackson��ܵ����䣡
 */
@RequestMapping("/test5")
@Controller
public class TestReponseViewHandler {
	
	@RequestMapping(value = "/handle1")
	// ��ǰ�����ķ���ֵ�ᱻ������Ӧ�壡
	@ResponseBody
	public String handle() {

		System.out.println("������handle1����");

		// ��Ӧ�����һ��success
		// HttpServletResponse.getwriter.print("success");
		return "success";

	}
	
	@RequestMapping(value = "/handle2",produces="text/html;charset=utf-8")
	// ��ǰ�����ķ���ֵ�ᱻ������Ӧ�壡
	@ResponseBody
	public String handle2() {

		System.out.println("������handle2����");

		// ��Ӧ�����һ��success
		// HttpServletResponse.getwriter.print("success");
		return "�ɹ���";

	}
	
	@RequestMapping(value = "/handle3")
	// ��ǰ�����ķ���ֵ�ᱻ������Ӧ�壡
	@ResponseBody
	public Book handle3() {

		System.out.println("������handle3����");

		Book book = new Book();
		
		book.setAuthor("��ж�");
		book.setBookName("�����μǡ�");
		book.setPrice(888.8);
		book.setAddress(new Address("001", "xxʡxx��"));
		// springmvc���Զ���java����תΪjsonstr������Ӧ
		return book;

	}
	
	@RequestMapping(value = "/handle4")
	@ResponseBody
	public String handle4(@RequestBody Book book) {

		System.out.println("������handle4����");
		
		System.out.println(book);

		return "success";

	}

}
