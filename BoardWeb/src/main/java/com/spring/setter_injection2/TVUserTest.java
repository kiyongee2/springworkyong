package com.spring.setter_injection2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserTest {

	public static void main(String[] args) {
		// Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext2.xml");
		
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
	}
}