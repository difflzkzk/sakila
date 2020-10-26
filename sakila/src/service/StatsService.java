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
	public Map<String,Object> getStats() { // public Map<String,Object> getStats()
		statsDao = new StatsDao();
		Connection conn = null;
		Map<String,Object>map = new HashMap<>();

		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db연결됨
			

			// 현재 날짜를 이용해 statsDao에 전달할 파라미터 객체를 만든 뒤
			Stats stats = new Stats();
			stats.setDay(this.formater());
			System.out.println("debug: instance-variable: stats=" + stats);
			// 현재 날짜에 대한 방문자 수 정보를 가져옴
			Stats todayStats = statsDao.selectDay(conn, stats);
			System.out.println("debug: instance-variable: todayStats=" + todayStats);

			System.out.println("debug: message: 'Execute SQL transection...'");
			Stats returnStats = statsDao.selectDay(conn, todayStats);
			System.out.println("debug: instance-variable: returnStats=" + returnStats);
			map.put("returnStats", returnStats);
			
			int totalCount = statsDao.totalCount(conn);
			map.put("totalCount", totalCount);
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
		return map; 
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
	// yyyy-MM-dd 오늘날짜를 출력하는 메서드임
		private String formater() {
			Calendar today = Calendar.getInstance(); // ���� ��¥�� Calendar ��ü�� �����ͼ� today ������ �ְ�
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd ���� ������ ���� ����
			String formaterdate = dateFormat.format(today.getTime()); // today ������ yyyy-MM-dd �������� ��ȯ�ؼ� String�� �������

			return formaterdate;
		}

	
}
