package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


import Dao.StatsDao;
import Util.DBUtil;
import Vo.Stats;

public class StatsService {
	 StatsDao statsDao;

	public int gettotalCount() { //total

		statsDao = new StatsDao();
		int totalCount = 0;
		Connection conn = null;

		try {

			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db연결

			totalCount = statsDao.totalCount(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCount;
	}
	
	// 오늘의 날짜
	public Stats getToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String day = formater.format(today); // yyyy-MM-dd형식인 포매터(오늘날짜)를 day에 넣어줌

		Stats stats = new Stats();
		stats.setDay(day); // --> DStats(오늘)
		return stats; // --> 오늘을 반환
	}

	// 오늘의 방문자를 조회
	public Stats getStats() { // public Map<String,Object> getStats()
		statsDao = new StatsDao();
		Connection conn = null;
		Stats returnStats = null;

		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db연결
			
			Stats returnstats = statsDao.selectDay(conn, this.getToday());
			conn.commit();

		}catch(Exception e){
			
		}try {
			conn.rollback();
		}catch(SQLException e){
			
		}finally {
			
		}try {
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return returnStats; 
	}
	

	// 방문자 세주는 것
	public void countStats() {
		statsDao = new StatsDao();
		Connection conn = null;
		
		try {
			

			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db연결
			
			Stats stats = new Stats();
			stats = statsDao.selectDay(conn, stats); // 오늘 날짜에 stats가 있는지 세줌

			if (statsDao.selectDay(conn, stats) == null) {
				statsDao.insertStats(conn, stats);
			} else {
				statsDao.updateStats(conn, stats);
			}
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// yyyy-MM-dd 포맷으로 오늘 날짜를 출력하는 메서드
		private String formater() {
			Calendar today = Calendar.getInstance(); // 현재 날짜를 Calendar 객체로 가져와서 today 변수에 넣고
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd 포맷 형식을 만든 다음
			String formaterdate = dateFormat.format(today.getTime()); // today 변수를 yyyy-MM-dd 포맷으로 변환해서 String에 집어넣음

			return formaterdate;
		}

	
}
