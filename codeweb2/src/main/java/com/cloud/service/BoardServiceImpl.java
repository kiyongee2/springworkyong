package com.cloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import com.cloud.mapper.BoardMapper;

@Log4j
@Service
@AllArgsConstructor  //�깮�꽦�옄 二쇱엯
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		//mapper.insert(board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public void modify(BoardVO board) {
		mapper.update(board);
	}

	@Override
	public void remove(Long bno) {
		mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
}
