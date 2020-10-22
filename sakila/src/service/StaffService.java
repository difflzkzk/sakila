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
		staffDao = new StaffDao(); //�޼ҵ带 ȣ���ϱ����� ��ü ����
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection(); //DB����
			
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
		
		//��ü ������ -> dao select �޼��忡 ���� ���������
	}
}
