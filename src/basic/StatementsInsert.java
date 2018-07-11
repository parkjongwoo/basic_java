package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementsInsert {

	public static void main(String[] args) {
		Connection conn = null;
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String user = "scott";
			String pw = "tiger";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("연결 성공");
			
			String sql = "DELETE FROM EMP_BAK "
					+ "WHERE deptno=30";
//			String sql = "UPDATE emp "
//					+ "SET "
//					+ "sal = nvl(sal,0)+300 "
//					+ "WHERE job='개발'";
//			String sql = "INSERT INTO emp(empno, ename, job)"
//					+ " VALUES(9001,'김자','개발')";
			Statement st = conn.createStatement();
			int result = st.executeUpdate(sql);
			st.close();
			conn.close();
			System.out.println(result+"입력 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		}		
	}
}
