package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;


public interface BoardMapper {
	
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board); 
	
	public BoardVO read(Long bno);
	
	public void delete(Long bno);
	
	public void update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
}
