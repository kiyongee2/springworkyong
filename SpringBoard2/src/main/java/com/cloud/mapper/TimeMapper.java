package com.cloud.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//������̼����� sql �ۼ�
	@Select("SELECT sysdate FROM dual")
	public String getTime();   
	
	//TimeMapper.xml���� sql �ۼ�
	public String getTime2();  
}
