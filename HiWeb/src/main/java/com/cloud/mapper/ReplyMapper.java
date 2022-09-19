package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {
	
	public void register(ReplyVO vo); //´ñ±Û Ãß°¡
	
	public List<ReplyVO> getReplyList(int bno);  //´ñ±Û ¸ñ·Ï Á¶È¸
	
	public ReplyVO getReply(int rno);  //´ñ±Û 1°³ Á¶È¸
	
	public void delete(ReplyVO vo); //´ñ±Û »èÁ¦
	
	public void update(ReplyVO vo); //´ñ±Û ¼öÁ¤
	
}
