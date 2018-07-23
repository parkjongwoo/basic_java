﻿package book.com.db.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//귀찮은 짓 덜 하게 하는 코드
public class JdbcUtil {
	   
		public static void close(ResultSet rs){
	        if(rs != null){
	            try {
	                rs.close();
	            } catch (SQLException e) {
	            }
	        }
	    }

	    public static void close(Statement stmt){
	        if(stmt != null){
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	            
	            }
	        }
	    }
	    
	    public static void close(PreparedStatement ps){
	        if(ps != null){
	            try {
	            	ps.close();
	            } catch (SQLException e) {
	            
	            }
	        }
	    }
	    
	    public static void close(Connection conn){
	        if(conn != null){
	            try {
	                conn.close();
	            } catch (SQLException e) {
	            }
	        }
	    }
 

	    public static void rollback(Connection conn){
	        if(conn != null){
	            try {
	                conn.rollback();
	            } catch (SQLException e) {
	            }
	        }
	    }
}

