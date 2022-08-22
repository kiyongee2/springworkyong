package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
//	@Qualifier("sony")
	private Speaker speaker;    //Speaker ��ü ����
	
	public LgTV() {
		System.out.println("===> LgTV ��ü ����");
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
		//System.out.println("LgTV--�Ҹ� �ø���");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("LgTV--�Ҹ� ������");
		speaker.volumeDown();
	}
}
