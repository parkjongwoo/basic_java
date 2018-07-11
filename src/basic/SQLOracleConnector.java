package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLOracleConnector implements SQLConnector {
	String user;
	String pw;
	String url;
	
	public SQLOracleConnector(String user, String pw, String url) {
		super();
		this.user = user;
		this.pw = pw;
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("커넥션 실패");
			e.printStackTrace();
		}
		return conn;
	}

}
