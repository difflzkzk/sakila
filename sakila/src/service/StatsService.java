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

	private Stats getToday() { // ���� ��¥ ���ϱ�
		Calendar today = Calendar.getInstance(); // getInstance() : �̱�������, �ϳ��� �ν��Ͻ��� ������ �����ؼ� ����
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-mm-dd ��������
		String day = formater.format(today);

		Stats stats = new Stats(); // �Ʒ� getToday�� ����� ��
		stats.setDay(day);
		return stats; // --->getToday()
	}

	// ������ �湮�ڸ� ��ȸ
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
			conn = dbUtil.getConnection(); // db����

			conn.setAutoCommit(false); // false ���̸� commit �ڵ� ����
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

	// �湮�� ���ִ� ��
	public void countStats() {

		statsDao = new StatsDao();

		Connection conn = null;
		try {
			conn.setAutoCommit(false);

			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); // db����

			Stats stats = this.getToday();
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

	public int totalCount() {

		statsDao = new StatsDao();
		int totalCount=0;
		Connection conn = null;

		try {
			conn.setAutoCommit(false);

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
}
