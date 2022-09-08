package com.cloud.service;

import java.util.List;

import com.cloud.repository.BoardVO;

public interface BoardService {
	
	public void insert(BoardVO vo);   //글 쓰기
	
	public List<BoardVO> getBoardList(BoardVO vo); //글 목록
	
	public String getNameByLogin(String id); //로그인한 글쓴이
	
	public BoardVO getBoard(int bno); //글 상세보기
	
	public void delete(BoardVO vo); //글 삭제
	 
	public void update(BoardVO vo); //글 수정
	
	public void updateCount(int bno); //조회수
	
}
