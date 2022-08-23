package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.repository.BoardDAO;
import com.cloud.repository.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	@Override
	public void insert(BoardVO vo) {
		dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		return dao.getBoard(bno);
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
