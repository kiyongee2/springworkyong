package com.spring.setter_injection;

public class LgTV implements TV{
	
	private Speaker speaker; 
	
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
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
