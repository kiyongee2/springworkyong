package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.repository.BoardDAO;
import com.cloud.repository.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	@Override
	public void insert(BoardVO vo) {  //글쓰기
		dao.insertBoard(vo);
	}

	@Override 
	public List<BoardVO> getBoardList(BoardVO vo) {  //글 목록(페이지)
		return dao.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(int bno) { //상세 보기
		return dao.getBoard(bno);
	}

	@Override
	public void delete(BoardVO vo) { //삭제
		dao.deleteBoard(vo);
	}

	@Override
	public void update(BoardVO vo) {  //수정
		dao.updateBoard(vo);
	}

	@Override
	public void updateCount(int bno) {  //조회수
		dao.updateCount(bno);
	}

	@Override
	public String getNameByLogin(String id) {
		return dao.getNameByLogin(id);
	}

}
