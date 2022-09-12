package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;

	/*@Override
	public List<BoardVO> getBoardList() { //목록 보기
		return mapper.getBoardList();
	}*/

	@Override
	public void insert(BoardVO vo) { //글쓰기
		mapper.insert(vo);
	}

	@Override
	public BoardVO getBoard(int bno) { //글 상세보기
		return mapper.getBoard(bno);
	}

	@Override
	public void delete(BoardVO vo) { //글 삭제
		mapper.delete(vo);
	}

	@Override
	public void update(BoardVO vo) { //글 수정
		mapper.update(vo);
	}

	@Override
	public void updateCount(int bno) { //조회수
		mapper.updateCount(bno);
	}

	@Override
	public List<BoardVO> getListWithPage(Criteria cri) { //목록 보기(페이징)
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) { //총 게시글 수
		return mapper.getTotalCount(cri);
	}
}
