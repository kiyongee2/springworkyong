package com.cloud.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.Criteria;
import com.cloud.domain.ReplyVO;

public interface ReplyService {
	
	public void register(ReplyVO vo); //��� �߰�
	
	public List<ReplyVO> getReplyList(int bno);  //��� ��� ��ȸ
	
	public ReplyVO getReply(int rno);  //��� 1�� ��ȸ
	
	public void delete(ReplyVO vo); //��� ����
	
	public void update(ReplyVO vo); //��� ����
}
