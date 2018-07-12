package com.util.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import info.InfoVO;

public class SQLConnectionExcutor {
	
	private Connection conn;
	
	public SQLConnectionExcutor(SQLConnector conn) throws ClassNotFoundException, SQLException {
		super();
		this.conn = conn.getConnection();
	}

//	public Connection getConnection() throws ClassNotFoundException, SQLException {
//		return conn.getConnection();
//	}
	
	public void insert(InfoVO vo) throws SQLException {
		String sql = "INSERT INTO "
				+ " STUDENT(SNAME,PNUM,PID,ZENDER,AGE,HOME) "
				+ " VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getName().trim());
		ps.setString(2, vo.getPhoneNum().trim());
		ps.setString(3, vo.getpID().trim());
		ps.setString(4, vo.getZender().trim());
		ps.setInt(5, vo.getAge());
		ps.setString(6, vo.getHome().trim());
		
		ps.executeUpdate();
	}
	
	public void update(InfoVO vo, String searchedPhoneNum) throws SQLException {
		String sql;
		if(searchedPhoneNum==null) {
			sql = "UPDATE STUDENT SET"
					+ " SNAME=?,PID=?,ZENDER=?,AGE=?,HOME=? "
					+ " WHERE PNUM=?";			
		}else {
			sql = "UPDATE STUDENT SET"
					+ " SNAME=?,PNUM=?,PID=?,ZENDER=?,AGE=?,HOME=? "
					+ " WHERE PNUM=?";			
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		
		if(searchedPhoneNum==null) {
			ps.setString(1, vo.getName().trim());		
			ps.setString(2, vo.getpID().trim());
			ps.setString(3, vo.getZender().trim());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getHome().trim());
			ps.setString(6, vo.getPhoneNum().trim());
		}else {
			ps.setString(1, vo.getName().trim());		
			ps.setString(2, vo.getPhoneNum().trim());
			ps.setString(3, vo.getpID().trim());
			ps.setString(4, vo.getZender().trim());
			ps.setInt(5, vo.getAge());
			ps.setString(6, vo.getHome().trim());
			ps.setString(7, searchedPhoneNum.trim());
		}		
		ps.executeUpdate();
	}
	
	public InfoVO searchPhoneNum(String phoneNum) throws SQLException {
		InfoVO vo = null;
		String sql = "SELECT * FROM STUDENT "
				+ " WHERE pnum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, phoneNum);
				
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo = new InfoVO(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5),
					rs.getString(6));			
		}
		
		return vo;
	}
	
	public ArrayList<InfoVO> searchAll() throws SQLException{
		ArrayList<InfoVO> list = new ArrayList<InfoVO>();
		InfoVO vo = null;
		
		String sql = "SELECT * FROM STUDENT ";
		PreparedStatement ps = conn.prepareStatement(sql);
						
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo = new InfoVO(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getInt(5),
					rs.getString(6));
			list.add(vo);
		}
		
		return list;
	}

	public int deleteInfoByPhoneNum(String phoneNum) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM STUDENT "
				+ " WHERE PNUM=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, phoneNum.trim());		
		result = ps.executeUpdate();
		return result;
	}

	
}
