package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	void insert(BoardVO vo);
	
	List<BoardVO> selectAll();
	
	BoardVO selectOne(int seq);
	
}
