package com.spring.cons_injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserTest {

	public static void main(String[] args) {
		// 생성자 인젝션 - SonySpeaker
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
		/*
		 1. SamsungTV 객체가 생성될때 매개변수가 있는 생성자가 사용됨
		 2. 생성자 인젝션으로 의존성 주입될 SonySpeaker가 먼저 객체 생성됨
		*/
	}
}
