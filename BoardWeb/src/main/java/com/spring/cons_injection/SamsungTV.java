package com.spring.cons_injection;

public class SamsungTV implements TV{
	//������ ������
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV(1) ��ü ����");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("SamsungTV(2) ��ü ����");
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV__���� �Ҵ�");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV__���� ����");
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
