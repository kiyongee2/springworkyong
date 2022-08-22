package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	@Override
	public void insert(BoardVO vo) {
		dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		return dao.getBoardList(vo);
	}

	@Override
	public BoardVO selectOne(int seq) {
		return dao.getBoard(seq);
	}

	@Override
	public void delete(BoardVO vo) {
		dao.deleteBoard(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.updateBoard(vo);
	}
	
}
