package crawling.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class CrawlingModel {
	Connection conn;
	
	public CrawlingModel() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
	}
}
