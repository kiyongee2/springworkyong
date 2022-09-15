package com.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.Criteria;
import com.cloud.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo); //´ñ±Û Ãß°¡
	
	public ReplyVO read(int bno);  //´ñ±Û Á¶È¸
	
	public int delete(int rno);   //´ñ±Û »èÁ¦
	
	public int update(ReplyVO vo); //´ñ±Û ¼öÁ¤
	
	public List<ReplyVO> getListWithPage(
			@Param("cri") Criteria cri,
			@Param("bno") int bno
	);
	
}
