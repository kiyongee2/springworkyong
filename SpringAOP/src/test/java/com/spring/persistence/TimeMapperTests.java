package com.spring.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	private TimeMapper mapper;
	
	@Test
	public void testGetTime() { //TimeMapper.java�� ���
		log.info(mapper.getTime());
	}
	
	@Test
	public void testGetTime2() { //TimeMapper.xml�� ���
		log.info(mapper.getTime2());
	}
}