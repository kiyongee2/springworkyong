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
		   SamsungTV�� LgTV�� �޼ҵ尡 �ٸ��Ƿ� TVUser �ڵ� ��κ��� �����ؾ�
		   TV�� ��ü�� �� �ִ�. TVUser�� ���� ���α׷��� ���� ����� ����������
		   ���� ������̸�, TV ��ü�� �����ϱⰡ ���� ���� ���̴�.
		 */
	}
}
