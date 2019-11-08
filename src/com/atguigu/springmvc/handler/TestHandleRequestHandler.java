package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * ��������ʱ��ͨ���Ĳ���
 * 
 * 1.��ȡ�������
 * 		web��  HttpServletRequest.getParameter("������");
 * 		springmvc:  �ڴ������Ĳ���λ��������Ӧ���β�������ҳ��Ĳ������ɣ�
 * 
 * 			ע�⣺ʹ�ô��ַ�ʽ�����뱣֤�β���������������һ�£������޷���ֵ����Ϊnull!
 * 
 * 		����������β����������������һ�£���Ҫʹ��@RequestParam(value="pw")��ʾ�󶨲�����
 * 
 * @RequestParam��
 * 		value:  �󶨵����������
 * 		required:  ����ǰ�Ĳ����Ƿ��Ǳ���ģ�Ĭ��Ϊtrue��Ҫ��url�б���Я���˲���������ͱ���400
 * 		defaultValue: ���û��Я���˲�����ʹ��Ĭ��ֵ��Ϊ����ֵ��
 * 	    
 * 
 * 2.��ȡָ������ͷ��Ӧ��value
 * 		web:HttpServletRequest.getHeader(String name)
 * 
 * 		springmvc�� @RequestHeader
 * 
 * 3.��ȡָ��cookie��Ӧ��value
 * 		web��Cookie [] cookies=HttpServletRequest.getCookies();
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

		System.out.println("������handle1����");
		
		System.out.println(username+":"+password);
		
		System.out.println("User-Agent:"+userAgent);
		
		System.out.println("JSESSIONID"+jesssionidValue);

		return "success";

	}

}
