package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepInsert {

	public static void main(String[] args) {
		Connection conn = null;
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String user = "scott";
			String pw = "tiger";
			String url = "jdbc:oracle:thin:@172.16.3.4:1521:orcl";
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("연결 성공");
			
//			int sabun = 9998;
//			String name = "남꽃분이";
//			String job = "SALESMAN";
//			String seq = "SEQ_TEMP_NO.nextval";
//			
//			String sql = "INSERT INTO emp(empno, ename, job)"
//					+ " VALUES(SEQ_TEMP_NO.nextval,?,?)";
//			PreparedStatement ps = conn.prepareStatement(sql);
////			ps.setString(1, seq);
//			ps.setString(1, name);
//			ps.setString(2, job);
//			int result = ps.executeUpdate();
//			ps.close();
//			conn.close();
//			System.out.println(result+"입력 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		}		
	}
}
