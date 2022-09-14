package com.spring.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	/*@Test
	public void testGetList() {
		
		List<BoardVO> list = mapper.getBoardList();
		
		list.stream()
			.map(board -> board.getBno())
			.forEach(board -> log.info(board));
	}*/
	
	/*@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		//2페이지 10개 출력
		cri.setPageNum(2);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPage(cri);
		
		list.stream()
			.map(board -> board.getTitle())
			.forEach(board -> log.info(board));
	}*/
	
	/*@Test
	public void testPageDTO() {
		Criteria cri = new Criteria();
		//cri.setPageNum(1);
		cri.setPageNum(11);
		
		PageDTO page = new PageDTO(cri, 149);  //total=150
		log.info(page);
	}*/
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "가을");
		map.put("C", "추석");
		map.put("W", "cloud");
		
		//중첩 Map 사용
		Map<String, Map<String, String>> outer = new HashMap<>();
		outer.put("map", map);  //xml쪽의 collection="map"
		
		List<BoardVO> list = mapper.searchTest(outer);
		
		log.info(list);
	}
	
	/*@Test
	public void testSearchPaging() {
		
		Criteria cri = new Criteria();
		//2페이지 10개 출력
		cri.setType("TC");   //title, content
		cri.setKeyword("추석");
		
		List<BoardVO> list = mapper.getListWithPage(cri);
		
		list.stream()
			.map(board -> board.getTitle())
			.forEach(board -> log.info(board));
	}*/
}
