package com.spring.setter_injection;

public class LgTV implements TV{
	
	private Speaker speaker; 
	
	public LgTV() {
		System.out.println("==> LgTV °´Ã¼ »ý¼º");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV__Àü¿ø ÄÒ´Ù");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV__Àü¿ø ²ö´Ù");
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
