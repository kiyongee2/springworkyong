package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	void insert(BoardVO vo);
	
	List<BoardVO> selectAll(BoardVO vo);
	
	BoardVO selectOne(int seq);
	
	void delete(BoardVO vo);
	
	void update(BoardVO vo);
	
}
