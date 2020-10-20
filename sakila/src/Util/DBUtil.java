package Util;

import java.sql.*;


public class DBUtil {

	public Connection getConnection() throws Exception{ // DB 연결  - 연결실패시 throw  
	
	final String URL = "jdbc:mariadb://localhost:3306/sakila";
	final String USER = "root";
	final String PASSWORD = "java1004";
	
	
	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	conn.setAutoCommit(false);
	
	// 메서드 - 객체명.메서드명(파라미터들);
	
	return conn;
	}
}