package com.cloud.persistence;

import java.sql.Connection;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn = JDBCUtil.getConnention();
		System.out.println(conn + " DB¿¡ ¿¬°áµÊ");
	}

}
