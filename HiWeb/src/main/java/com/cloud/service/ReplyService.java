package com.cloud.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.Criteria;
import com.cloud.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo); //��� �߰�
	
	public List<ReplyVO> getReplyList(int bno);  //��� ��� ��ȸ
	
}
