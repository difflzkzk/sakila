package service;

public class myPortQuery {
		public final static String SHOW_STAFF_IMPORT = "SELECT s.username AS '����' , s.last_name AS '�̸�' , a.phone AS '����ó' , a.address AS '�ּ�' , s.email AS 'E-mail'\r\n" + 
															"\r\n" + 
															"FROM staff s\r\n" + 
															"\r\n" + 
															"JOIN address a ON s.address_id = a.address_id";
}
