package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Vo.Staff;
import service.StaffQuery;


public class StaffDao {
	public Staff selectStaffByKey(Connection conn,Staff staff) throws Exception {
		System.out.println("Debug: selectStaffByKey ����");
		Staff returnStaff = null;
		
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setString(1,staff.getEmail() );
		stmt.setString(2,staff.getPassword() );
		ResultSet rs = stmt.executeQuery(); //����
		System.out.println(rs+"����");
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getString("email"));
			System.out.println(rs.getString("email")+"����");
			returnStaff.setPassword(rs.getString("username"));
			System.out.println(rs.getString("username")+"����");
		}
		
		
		return returnStaff;
	}
}
