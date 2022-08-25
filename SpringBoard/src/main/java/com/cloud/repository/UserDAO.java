package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.cloud.common.JDBCUtil;

@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String LOGIN = 
			"SELECT * FROM users WHERE id = ? and passwd = ?";
	
	//로그인 처리
	public boolean login(UserVO vo) {
		try {
			conn = JDBCUtil.getConnention();
			pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return false;
	}
}
