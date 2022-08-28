package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.BoardVO;

public interface BoardMapper {
	
	public void insert(BoardVO vo);   //�� ����
	
	public List<BoardVO> getBoardList(); //�� ���
	
	public BoardVO getBoard(int bno); //�� �󼼺���
	
	public void delete(BoardVO vo); //�� ����
	
	public void update(BoardVO vo); //�� ����
	
	public void updateCount(int bno); //��ȸ��
}