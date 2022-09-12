package com.spring.persistence;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.domain.ReplyVO;
import com.cloud.mapper.BoardMapper;
import com.cloud.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	//해당 bno 확인
	private int[] bnoArr = {1, 2, 3, 4, 6};
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	/*@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			//게시물의 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}*/
	
	/*@Test
	public void testRead() {
		int targetBno = 3;
		ReplyVO vo = mapper.read(targetBno);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		int targetBno = 2;
		mapper.delete(targetBno);
	}
	
	@Test
	public void testUpdate() {
		int targetBno = 10;
		ReplyVO vo = mapper.read(targetBno);
		vo.setReply("Update Reply ");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT: " + count);
	}*/
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPage(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
}
