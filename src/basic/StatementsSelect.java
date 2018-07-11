package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementsSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String user = "scott";
			String pw = "tiger";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("연결 성공");
			
			String sql = "SELECT * FROM emp";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			StringBuffer sb = new StringBuffer();
			while(rs.next()) {
				sb.append(rs.getString("ename")).append(':').
				append(rs.getString("job")).append(':').
				append(rs.getString("sal")).append('\n');
			}
			System.out.println(sb);
			st.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}

}
