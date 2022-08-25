package com.spring.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. spring 컨테이너 구동
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		//3. 로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("cloud");
		vo.setPasswd("cloud");
		
		boolean result = userService.login(vo);
		if(result) {
			System.out.println("로그인에 성공했습니다.");
		}else {
			System.out.println("아이디나 비밀번호를 확인해주세요");
		}
		
		container.close();
	}
}
