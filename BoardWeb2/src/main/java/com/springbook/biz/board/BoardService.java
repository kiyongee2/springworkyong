package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	//�� ���
	void insertBoard(BoardVO vo);
	
	//�� ��� ��ȸ
	List<BoardVO> getBoardList();
	
	//�� �� ��ȸ
	BoardVO getBoard(int seq);
	
	//�� ����
	void deleteBoard(BoardVO vo);
	
	//�� ����
	void updateBoard(BoardVO vo);
}
