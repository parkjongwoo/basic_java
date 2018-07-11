package basic;

import java.sql.Connection;

public class SQLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "scott";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		Connection conn = new SQLConnectionExcutor(new SQLOracleConnector(user, pw, url)).getConnection();
		
	}

}
