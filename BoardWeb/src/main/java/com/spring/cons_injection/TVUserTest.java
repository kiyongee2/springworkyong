package com.spring.cons_injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserTest {

	public static void main(String[] args) {
		// ������ ������ - SonySpeaker
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
		/*
		 1. SamsungTV ��ü�� �����ɶ� �Ű������� �ִ� �����ڰ� ����
		 2. ������ ���������� ������ ���Ե� SonySpeaker�� ���� ��ü ������
		*/
	}
}
