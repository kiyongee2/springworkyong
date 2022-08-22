package com.spring.cons_injection;

public class LgTV implements TV{
	
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

	@Override
	public void volumeUp() {
		System.out.println("LgTV__소리 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV__소리 내린다.");
	}

}
