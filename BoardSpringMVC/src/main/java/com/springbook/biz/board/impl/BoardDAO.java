package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT =
			"INSERT INTO board(seq, title, writer, content, regdate) VALUES "
			+ "((SELECT NVL(MAX(seq), 0)+1 FROM board), ?, ?, ?, CURRENT_TIMESTAMP())";
	private final String BOARD_LIST =
			"SELECT * FROM board ORDER BY seq DESC";
	private final String BOARD_ONE =
			"SELECT * FROM board WHERE seq = ?";
	private final String BOARD_UPDATE =
			"UPDATE board SET title = ?, content = ? WHERE seq = ?";
	private final String BOARD_DELETE =
			"DELETE FROM board WHERE seq = ?";
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==> insertBoard()");
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	//글 목록
	public List<BoardVO> getBoardList(){
		System.out.println("==> getBoardList()");
		List<BoardVO> boardList = new ArrayList<>();
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				boardList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return boardList;
	}
	
	//글 상세 보기
	public BoardVO getBoard(int seq) {
		System.out.println("==> getBoard()");
		conn = JDBCUtil.getConnection();
		BoardVO board = new BoardVO();
		try {
			pstmt = conn.prepareStatement(BOARD_ONE);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return board;
	}
	
	//글 수정하기
	public void updateBoard(BoardVO vo) {
		System.out.println("==> updateBoard()");
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	//글 삭제
	public void deleteBoard(int seq) {
		System.out.println("==> deleteBoard()");
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
