package com.spring.cons_injection;

public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("==> LgTV ��ü ����");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV__���� �Ҵ�");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV__���� ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV__�Ҹ� �ø���.");
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV__�Ҹ� ������.");
	}

}
