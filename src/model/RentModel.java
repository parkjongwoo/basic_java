package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.RentVO;

public class RentModel {

	Connection con;

	public RentModel() throws Exception {
		con = DBConn.getConnection();
	}
	
	public void rentVideo(String pNum, String vNum) throws Exception {
		String sql = "INSERT INTO v_rent (rid, cpid, vid, rsdate) VALUES ( "
				+ "seq_rid.nextval, ?, ?, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pNum);
		ps.setInt(2, Integer.valueOf(vNum));		
		ps.executeUpdate();
		ps.close();
	}

	public void returnVideo(String vNum)  throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE v_rent SET "
				+ " redate=sysdate "
				+ " where vid=? and redate IS NULL";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(vNum.trim()));		
		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<RentVO> searchRentedVideoByPNum(String pNum) throws SQLException  {
		ArrayList<RentVO> list = new ArrayList<RentVO>();
		String sql = "SELECT R.RID, V2.VID, V2.MTITLE, C.CNAME, R.CPID, " + 
				" R.RSDATE+7 AS RSCHE, NVL2(R.REDATE,'반납','미반납') AS ISR " + 
				" FROM V_CUSTOMER C INNER JOIN V_RENT R " + 
				" ON C.CPID=R.CPID INNER JOIN " + 
				" (SELECT V.VID ,M.MTITLE " + 
				" FROM V_VIDEO V INNER JOIN V_MOVIE M " + 
				" ON V.MID=M.MID) V2 " + 
				" ON R.VID=V2.VID " + 
				" WHERE C.CPID=? " + 
				" ORDER BY RSDATE DESC";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pNum);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			RentVO dao = new RentVO();
			dao.setRid(rs.getInt(1));
			dao.setVid(rs.getInt(2));
			dao.setVname(rs.getString(3));
			dao.setCname(rs.getString(4));
			dao.setCpid(rs.getString(5));
			dao.setReturnSche(rs.getString(6));
			dao.setReturned(rs.getString(7));			
			list.add(dao);
		}
		rs.close();
		return list;
	}
}
