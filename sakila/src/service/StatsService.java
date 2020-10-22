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
			conn = dbUtil.getConnection(); // db����

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
	
	// ������ ��¥
	public Stats getToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String day = formater.format(today); // yyyy-MM-dd������ ������(���ó�¥)�� day�� �־���

		Stats stats = new Stats();
		stats.setDay(day); // --> DStats(����)
		return stats; // --> ������ ��ȯ
	}

	// ������ �湮�ڸ� ��ȸ
	public Stats getStats() { // public Map<String,Object> getStats()
		statsDao = new StatsDao();
		Connection conn = null;
		Stats returnStats = null;

		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db����
			
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
	

	// �湮�� ���ִ� ��
	public void countStats() {
		statsDao = new StatsDao();
		Connection conn = null;
		
		try {
			

			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db����
			
			Stats stats = new Stats();
			stats = statsDao.selectDay(conn, stats); // ���� ��¥�� stats�� �ִ��� ����

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
	// yyyy-MM-dd �������� ���� ��¥�� ����ϴ� �޼���
		private String formater() {
			Calendar today = Calendar.getInstance(); // ���� ��¥�� Calendar ��ü�� �����ͼ� today ������ �ְ�
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd ���� ������ ���� ����
			String formaterdate = dateFormat.format(today.getTime()); // today ������ yyyy-MM-dd �������� ��ȯ�ؼ� String�� �������

			return formaterdate;
		}

	
}
