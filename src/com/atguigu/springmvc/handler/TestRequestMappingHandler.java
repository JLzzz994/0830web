package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 1. @RequestMapping��ע��λ��
 * @RequestMapping���Ա�ע����ͷ�����
 * 		�����ϣ�  Ϊ��ǰ�����󶨴����url
 * 		����: Ϊ��ǰ������б�ע��@RequestMappingע��ķ������ṩһ�㸸·��
 * 				
 * 
 * 	��֤�� ��ͬһ����Ŀ�У�������ͬһ��urlӳ�䵽��ͬ�ı�ע��@RequestMapping�ķ����ϣ�
 * 			��֤���ܳ�������ͬ��@RequestMapping
 * 
 * 2. @RequestMapping��value��method����
 * 			value�� ���Ƶ�ǰ����ƥ���url��ֵ
 * 			method:   ���Ƶ�ǰ����ƥ���url������ʽ�����������������û�����ơ�
 * 						���������url���͵�method�������Ĳ�ƥ�䣬����405��
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
		
		System.out.println("TestRequestMappingHandler������hello����");
		
		return "success";
		
	}

}
