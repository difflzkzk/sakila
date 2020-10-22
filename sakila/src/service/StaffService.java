package service;

import java.sql.Connection;
import java.sql.SQLException;

import Dao.StaffDao;
import Util.DBUtil;
import Vo.Staff;

public class StaffService {
	private StaffDao staffDao;
	
	public Staff getStaffBYKey(Staff staff) {
		Staff returnStaff = null;
		staffDao = new StaffDao(); //메소드를 호출하기위한 객체 생성
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); //DB연결
			
			returnStaff = staffDao.selectStaffByKey(conn,staff);
			
			conn.commit();
			
		}catch (Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnStaff;
		
		//객체 생성후 -> dao select 메서드에 넣을 값만들어줌
	}
}
