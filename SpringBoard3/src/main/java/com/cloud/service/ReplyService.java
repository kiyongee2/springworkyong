package com.cloud.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.Criteria;
import com.cloud.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo); //´ñ±Û Ãß°¡
	
	public ReplyVO get(int bno);  //´ñ±Û Á¶È¸
	
	public int remove(int rno);   //´ñ±Û »èÁ¦
	
	public int modify(ReplyVO vo); //´ñ±Û ¼öÁ¤
	
	public List<ReplyVO> getList(Criteria cri, int bno); //´ñ±Û ¸ñ·Ï
}
