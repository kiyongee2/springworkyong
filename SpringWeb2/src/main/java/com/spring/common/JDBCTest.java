package com.spring.common;

import java.sql.Connection;

public class JDBCTest {

	public static void main(String[] args) {
		Connection con = JDBCUtil.getConnention();
		System.out.println(con + " ��ü ���� ����!!");
	}

}
