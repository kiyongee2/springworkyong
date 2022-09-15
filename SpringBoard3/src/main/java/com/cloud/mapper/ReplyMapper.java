package com.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.Criteria;
import com.cloud.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo); //��� �߰�
	
	public ReplyVO read(int bno);  //��� ��ȸ
	
	public int delete(int rno);   //��� ����
	
	public int update(ReplyVO vo); //��� ����
	
	public List<ReplyVO> getListWithPage(
			@Param("cri") Criteria cri,
			@Param("bno") int bno
	);
	
}
