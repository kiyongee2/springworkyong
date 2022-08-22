package com.spring.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.BoardService;
import com.spring.board.BoardVO;
import com.spring.common.Log4jAdvice;
import com.spring.common.LogAdvice;

//@Service("boardService")
public class BoardServiceImpl2 implements BoardService{

	@Autowired
	//private BoardDAO boardDAO;
	private BoardDAOSpring boardDAO;
	
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	public BoardServiceImpl2() {
		//log = new LogAdvice();
		//log = new Log4jAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		//boardDAO.insertBoard(vo);  // 100�� �� ��� ����
		boardDAO.insertBoard(vo);  // Ʈ����� �׽�Ʈ Exception �߻�
	}

	@Override
	public List<BoardVO> getBoardList() {
		//log.printLog();
		//log.printLogging();
		return boardDAO.getBoardList();
	}
}
