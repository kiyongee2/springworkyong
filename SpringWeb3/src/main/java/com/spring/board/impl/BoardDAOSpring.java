package com.spring.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT =
			"INSERT INTO board(bno, title, writer, content) VALUES "
			+ "(bno.NEXTVAL, ?, ?, ?)";
	//트랜잭션 테스트 용
	/*private final String BOARD_INSERT =
			"INSERT INTO board(bno, title, writer, content) VALUES "
					+ "(?, ?, ?, ?)";*/
	private final String BOARD_LIST =
			"SELECT * FROM board ORDER BY bno DESC";
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), 
				vo.getContent());
		//트랜잭션 테스트용 
		/*jdbcTemplate.update(BOARD_INSERT, vo.getBno(), vo.getTitle(), vo.getWriter(), 
				vo.getContent());*/
	}
	
	//글 목록
	public List<BoardVO> getBoardList(){
		System.out.println("==> Spring JDBC로 getBoardList() 기능 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setBno(rs.getInt("bno"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		return board;
	}
	
}
