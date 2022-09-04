package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloud.common.JDBCUtil;

@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String LOGIN = 
			"SELECT count(*) FROM t_user WHERE id = ? and passwd = ?";
	private final String USER_LIST =
			"SELECT * FROM t_user";
	private final String USER_INSERT =
			"INSERT INTO t_user(id, passwd, name, role) VALUES (?, ?, ?, ?)";
	private final String USER_ONE = 
			"SELECT * FROM t_user WHERE id = ?";
	
	//로그인 처리
	public int login(UserVO vo) {
		try {
			conn = JDBCUtil.getConnention();
			pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return 0;
	}
	
	//회원 가입
	public void insertUser(UserVO user) {
		try {
			conn = JDBCUtil.getConnention();
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, "USER");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//회원 목록
	public List<UserVO> getUserList(){
		List<UserVO> userList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnention();
			pstmt = conn.prepareStatement(USER_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return userList;
	}
	
	//회원 정보
	public UserVO getUser(String id) {
		UserVO user = new UserVO();
		try {
			conn = JDBCUtil.getConnention();
			pstmt = conn.prepareStatement(USER_ONE);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return user;
	}
	
}







