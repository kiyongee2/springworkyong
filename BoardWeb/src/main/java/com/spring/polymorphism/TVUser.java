package com.spring.polymorphism;

public class TVUser {

	public static void main(String[] args) {
		
		TV tv = new LgTV();  //SamsungTV()로 교체
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		/*
		 TVUser 클래스는 TV 인터페이스 타입의 변수로 LgTV 객체를 참조하고 있다.
		 이렇게 묵시적 형변환을 이용하여 객체를 참조하면 쉽게 교체할 수 있다.
		 */
	}
}
