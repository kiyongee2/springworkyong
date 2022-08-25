package com.spring.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;
import com.spring.user.UserVO;

@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = 
			"SELECT * FROM users WHERE id = ? and passwd = ?";
	
	//�α��� ó��
	public boolean login(UserVO vo) {
		try {
			System.out.println("==> JDBC�� login() ó��");
			conn = JDBCUtil.getConnention();
			pstmt = conn.prepareStatement(USER_GET);
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
