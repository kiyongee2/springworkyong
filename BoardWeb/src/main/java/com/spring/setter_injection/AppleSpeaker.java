package com.spring.setter_injection;

public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		System.out.println("==> AppleSpeaker ��ü ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker -- �Ҹ� �ø�");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker -- �Ҹ� ����");
	}
}