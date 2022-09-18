package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.domain.Criteria;
import com.cloud.domain.ReplyVO;
import com.cloud.mapper.BoardMapper;
import com.cloud.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional  //boardMapper와 연동함
	@Override
	public int register(ReplyVO vo) {
		//댓글 개수
		boardMapper.updateReplyCnt(vo.getBno(), 1);  //1 - amount(개수)
		return mapper.register(vo);
	}
	
	@Override
	public List<ReplyVO> getReplyList(int bno) {
		return mapper.getReplyList(bno);
	}

	/*@Override
	public int delete(int rno) {
		return mapper.delete(rno);
	}*/

	/*@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}*/

	
}
