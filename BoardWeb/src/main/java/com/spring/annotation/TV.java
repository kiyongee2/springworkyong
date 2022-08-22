package com.spring.annotation;

public interface TV {
	
	public void powerOn();
	
	public void powerOff();
	
	public void volumeUp();
	
	public void volumeDown();
	
	/*
	 인터페이스를 이용하여 모든 TV 클래스가 같은 메소드들을 가질 수밖에 없도록 
	 강제할 수 있게 되었다.
	 */
}
