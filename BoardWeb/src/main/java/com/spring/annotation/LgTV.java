package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
//	@Qualifier("sony")
	private Speaker speaker;    //Speaker 객체 선언
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV__전원 켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV__전원 끈다");
	}

	@Override
	public void volumeUp() {
		//System.out.println("LgTV--소리 올린다");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("LgTV--소리 내린다");
		speaker.volumeDown();
	}
}
