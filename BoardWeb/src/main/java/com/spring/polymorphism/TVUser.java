package com.spring.polymorphism;

public class TVUser {

	public static void main(String[] args) {
		
		TV tv = new LgTV();  //SamsungTV()�� ��ü
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		/*
		 TVUser Ŭ������ TV �������̽� Ÿ���� ������ LgTV ��ü�� �����ϰ� �ִ�.
		 �̷��� ������ ����ȯ�� �̿��Ͽ� ��ü�� �����ϸ� ���� ��ü�� �� �ִ�.
		 */
	}
}
