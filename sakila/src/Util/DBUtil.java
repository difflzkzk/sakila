package Util;

import java.sql.*;


public class DBUtil {

	public Connection getConnection() throws Exception{ // DB ����  - ������н� throw  
	
	final String URL = "jdbc:mariadb://localhost:3306/sakila";
	final String USER = "root";
	final String PASSWORD = "java1004";
	
	
	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	conn.setAutoCommit(false);
	
	// �޼��� - ��ü��.�޼����(�Ķ���͵�);
	
	return conn;
	}
}