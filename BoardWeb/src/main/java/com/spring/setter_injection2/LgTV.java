package com.spring.setter_injection2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	//@Qualifier("sony")  --> bean으로 설정함
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("==> LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV__전원 켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV__전원 끈다");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() 호출");
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
