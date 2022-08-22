package com.spring.setter_injection2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	//@Qualifier("sony")  --> bean���� ������
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
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() ȣ��");
		this.speaker = speaker;
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
