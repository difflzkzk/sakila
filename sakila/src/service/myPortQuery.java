package service;

public class myPortQuery {
		public final static String SHOW_STAFF_IMPORT = "SELECT s.username AS '별명' , s.last_name AS '이름' , a.phone AS '연락처' , a.address AS '주소' , s.email AS 'E-mail'\r\n" + 
															"\r\n" + 
															"FROM staff s\r\n" + 
															"\r\n" + 
															"JOIN address a ON s.address_id = a.address_id";
}
