package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

//@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//sql ��ɾ�
	private final String BOARD_INSERT =
			"INSERT INTO board(seq, title, writer, content, regdate) VALUES "
			+ "((SELECT NVL(MAX(seq), 0)+1 FROM board), ?, ?, ?, CURRENT_TIMESTAMP())";
//			+ "(?, ?, ?, ?, CURRENT_TIMESTAMP())";
	private final String BOARD_LIST =
			"SELECT * FROM board ORDER BY seq DESC";
	
	//�� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("==> Spring JDBC�� insertBoard() ��� ó��");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(),vo.getContent());
//		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(),vo.getContent());
		
	}
	
	//�� ���
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("==> Spring JDBC�� getBoardList() ��� ó��");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegdate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		return board;
	}
}
