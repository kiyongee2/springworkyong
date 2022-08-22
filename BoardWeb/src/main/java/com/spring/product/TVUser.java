package com.spring.product;

public class TVUser {

	public static void main(String[] args) {
		/*SamsungTV tv = new SamsungTV();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();*/
		
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
		/*
		   SamsungTV와 LgTV는 메소드가 다르므로 TVUser 코드 대부분을 수정해야
		   TV를 교체할 수 있다. TVUser와 같은 프로그램이 여러 개라면 유지보수는
		   더욱 힘들것이며, TV 교체를 결정하기가 쉽지 않을 것이다.
		 */
	}
}
