package Dao;

import java.sql.*;


import Vo.Stats;
import service.StatsQuery;

public class StatsDao {
	// rs.next()������ true, ������ false
	
	public Stats selectDay(Connection conn,Stats stats)throws Exception{
		

		//Prepared -> StatsQuery ��  SELECT_DAY�� �־��� Resultset -> excuteQuery

		//stats 의 값에 값을 받아 넣음
		Stats returnStats = null;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_STATS);
		stmt.setString(1, stats.getDay());//���� ��¥
		ResultSet rs = stmt.executeQuery();//����
		System.out.println("stmt"+stmt);
		
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCount(rs.getInt("count"));
		}

		return returnStats; // 

	}
	public void insertStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		ResultSet rs = stmt.executeQuery();
		stmt.executeUpdate();
	}

	public void updateStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		ResultSet rs = stmt.executeQuery();
		stmt.executeUpdate();
	}


	public int totalCount(Connection conn) throws Exception{
		// TODO Auto-generated method stub
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_SUM_STATS);
		ResultSet rs = stmt.executeQuery();
		int sum = 0;
		while(rs.next()){
			sum = sum + rs.getInt("count");
		}
		rs.close();
		stmt.executeUpdate();
		return sum;
	}
}

