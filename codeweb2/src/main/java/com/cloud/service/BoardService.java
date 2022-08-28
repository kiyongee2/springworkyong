package com.cloud.service;

import java.util.List;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;


public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public void modify(BoardVO board);
	
	public void remove(Long bno);
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);
	
	//寃��깋 泥섎━
	//List<BoardVO> searchTest(Map<String, Map<String, String>> map);
}
