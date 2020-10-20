package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Dao.StatsDao;
import Util.DBUtil;
import Vo.Stats;

public class StatsService {
	private static StatsDao statsDao;

	private Stats getToday() { // 오늘 날짜 구하기
		Calendar today = Calendar.getInstance(); // getInstance() : 싱글턴패턴, 하나의 인스턴스만 가지고 공유해서 쓴다
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-mm-dd 형식으로
		String day = formater.format(today);

		Stats stats = new Stats(); // 아래 getToday에 사용할 값
		stats.setDay(day);
		return stats; // --->getToday()
	}

	// 오늘의 방문자를 조회
	public Stats getStats() { // public Map<String,Object> getStats() {}
		Stats returnStats = null;
		statsDao = new StatsDao();
		Connection conn = null;
		/*
		 * final String URL = "jdbc:mariadb://localhost:3306/sakila"; final String USER
		 * = "root"; final String PASSWORD = "java1004";
		 */

		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db연결

			conn.setAutoCommit(false); // false 값이면 commit 자동 수행
			returnStats = statsDao.selectDay(conn, this.getToday());
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
		return returnStats; // ->
		// Map<String,Objdect> map = new HashMap();
	}

	// 방문자 세주는 것
	public void countStats() {

		statsDao = new StatsDao();

		Connection conn = null;
		try {
			conn.setAutoCommit(false);

			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db연결

			Stats stats = this.getToday();
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

	public int totalCount() {

		statsDao = new StatsDao();
		int totalCount=0;
		Connection conn = null;

		try {
			conn.setAutoCommit(false);

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
}
