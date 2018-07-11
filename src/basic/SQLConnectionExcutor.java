package basic;

import java.sql.Connection;

public class SQLConnectionExcutor {
	
	private SQLConnector conn;

	public SQLConnectionExcutor(SQLConnector conn) {
		super();
		this.conn = conn;
	}

	public Connection getConnection() {
		return conn.getConnection();
	}
	
	
}
