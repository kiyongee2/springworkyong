package com.cloud.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//어노테이션으로 sql 작성
	@Select("SELECT sysdate FROM dual")
	public String getTime();   
	
	//TimeMapper.xml에서 sql 작성
	public String getTime2();  
}
