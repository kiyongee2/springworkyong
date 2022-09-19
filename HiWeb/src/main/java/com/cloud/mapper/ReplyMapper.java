package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {
	
	public void register(ReplyVO vo); //��� �߰�
	
	public List<ReplyVO> getReplyList(int bno);  //��� ��� ��ȸ
	
	public ReplyVO getReply(int rno);  //��� 1�� ��ȸ
	
	public void delete(ReplyVO vo); //��� ����
	
	public void update(ReplyVO vo); //��� ����
	
}
