package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {
	
	public int register(ReplyVO vo); //´ñ±Û Ãß°¡
	
	public List<ReplyVO> getReplyList(int bno);  //´ñ±Û ¸ñ·Ï Á¶È¸

}
