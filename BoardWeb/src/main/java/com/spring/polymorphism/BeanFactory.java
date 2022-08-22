package com.spring.polymorphism;

public class BeanFactory {

	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
	/*
	 getBean() 메소드는 매개변수로 받은 beanName에 해당하는 
	 객체를 생성하여 리턴한다. 
	 */
}
