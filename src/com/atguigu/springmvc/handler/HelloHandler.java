package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ����springmvc������Ǹ�������
@Controller
public class HelloHandler {
	
	// ������ɺ�ת����success.jspҳ��
	// springmvc��ת�����ĸ�ҳ�棬ֻ��Ҫ��ҳ���·��ֱ�ӷ��ؼ���
	// ����springmvc���˷����Ǵ���hello����
	@RequestMapping(value="/hello")
	public String handle1() {
		
		System.out.println("������hello����");
		
		//return "/WEB-INF/pages/success.jsp";
		
		return "success";
		
	}

}
