package com.cloud.service;

import java.util.List;

import com.cloud.repository.BoardVO;

public interface BoardService {
	
	void insert(BoardVO vo);
	
	List<BoardVO> getBoardList();
	
	BoardVO getBoard(int bno);
	
	void delete(BoardVO vo);
	
	void update(BoardVO vo);
	
}
