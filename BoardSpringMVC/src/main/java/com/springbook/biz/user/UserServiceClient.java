package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService service = 
				(UserService) container.getBean("userService");
		
		//�α��� ���
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test000");
		
		UserVO user = service.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
			System.out.println(user.toString());
		}else {
			System.out.println("�α��� ����!!");
		}
	
		container.close();
	}
}
