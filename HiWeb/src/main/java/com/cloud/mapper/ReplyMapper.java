package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {
	
	public int register(ReplyVO vo); //��� �߰�
	
	public List<ReplyVO> getReplyList(int bno);  //��� ��� ��ȸ

}
