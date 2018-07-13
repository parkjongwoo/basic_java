package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Genre;
import model.vo.Video;

public class VideoModel {

	Connection con;
	public ArrayList<Genre> genreList;
	
	public VideoModel() throws Exception {

		// 1. 드라이버 로딩
		// 2. Connection 객체 얻어오기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:Oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		
		con = DriverManager.getConnection(url, user, password);
		loadgenre();
	}

	public void insertVideo(Video dao, int count) throws Exception {
		// 3. sql 문장 만들기
		// 4. sql 전송객체(PreparedStatement)
		// 5. sql 전송
		// 6. 닫기(PreparedStatement만 닫기)
		int result = insertMovie(dao);
		
		if(result>0) {
			// 영화 입력 완료. 비디오 입력시작
			String sql = "INSERT INTO V_VIDEO (vid,mid) "
					+ " VALUES (seq_vid.NEXTVAL,seq_mid.CURRVAL)";
			PreparedStatement ps = con.prepareStatement(sql);
			for(int i=0;i<count;i++) {
				/*result = */ps.executeUpdate();					
			}
		}else if(result==-1) {
			//영화제목,감독이 같은 영화가 이미 있음. 해당 영화 검색해서 키값 받아서 처리.
			
		}else {
			// 위의 영화 입력 함수에서 예외발생해서 실행되지 않는 조건.
		}
		
//		searchMoviewithTitle(dao.getVideoName(),dao.getDirector());
	}
	
	private int insertMovie(Video dao) throws Exception{
		int result=0;
		String sql = "INSERT INTO V_MOVIE (mid,genid,mtitle,mdir,mact,mdis) "
				+ " VALUES (seq_mid.NEXTVAL,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dao.getGenre());
			ps.setString(2, dao.getVideoName());
			ps.setString(3, dao.getDirector());
			ps.setString(4, dao.getActor());
			ps.setString(5, dao.getExp());
			
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// TO-DO 고유값 제약 위반시 -1반환. 영화 검색해서 키 값 받아 비디오 입력 처리.
			result = -1;
			System.out.println("영화 고유값 위배. 기존 영화 검색해서 키 사용해야함.");
		}
		return result;
	}
	public String searchMoviewithTitle(String title,String director)  throws Exception{
		// TODO Auto-generated method stub
//		String sql = "SELECT * FROM v_movie WHERE mtitle=? and mdir=?";
//		PreparedStatement ps = con.prepareStatement(sql);		
//		ps.setString(1, title);		
//		ps.setString(2, director);	
//		
//		ResultSet rs = ps.executeQuery();
//		Video
//		while(rs.next()) {
//			dao = new Video();
//			dao.setGenre(rs.getString(2));
//			dao.setVideoName(rs.getString(3));
//			dao.setDirector(rs.getString(4));
//			dao.setActor(rs.getString(5));
//			dao.setExp(rs.getString(6));
//		}
//		ps.close();
		return null;
	}
	
	public void loadgenre() throws Exception{
		String sql = "SELECT * FROM v_genre";
		PreparedStatement ps = con.prepareStatement(sql);		
		genreList = new ArrayList<Genre>();
		Genre dao;
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			dao = new Genre();
			dao.setGenid(rs.getString(1));
			dao.setGenname(rs.getString(2));
			genreList.add(dao);
		}
		ps.close();
		System.out.println(genreList.toString());
	}
	
	public void deleteVideo() {
		// TODO Auto-generated method stub
		
	}

	public void updateVideo() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ArrayList<String>> searchVideoByTitle(String text) throws Exception {
		String sql = "SELECT v.vid, m.mtitle, g.genname, m.mdir, m.mact FROM v_video v INNER JOIN v_movie m"
				+ " ON m.mid=v.mid "
				+ " INNER JOIN v_genre g "
				+ " ON m.genid=g.genid "
				+ " WHERE m.mtitle LIKE ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+text.trim()+"%");
		ResultSet rs = ps.executeQuery();
		ArrayList<ArrayList<String>> model = new ArrayList<ArrayList<String>>();
		
		while(rs.next()) {
			ArrayList<String> tuple = new ArrayList<String>();
			
			tuple.add(rs.getString(1));
			tuple.add(rs.getString(2));
			tuple.add(rs.getString(3));
			tuple.add(rs.getString(4));
			tuple.add(rs.getString(5));
			model.add(tuple);			
		}
		ps.close();		
		return model;		
	}

	public ArrayList<ArrayList<String>> searchVideoByDirector(String text) throws Exception  {
		String sql = "SELECT v.vid, m.mtitle, g.genname, m.mdir, m.mact FROM v_video v INNER JOIN v_movie m"
				+ " ON m.mid=v.mid "
				+ " INNER JOIN v_genre g "
				+ " ON m.genid=g.genid "
				+ " WHERE m.mdir LIKE ?";	
		
		PreparedStatement ps = con.prepareStatement(sql);		
		ps.setString(1, "%"+text.trim()+"%");
		ResultSet rs = ps.executeQuery();
		ArrayList<ArrayList<String>> model = new ArrayList<ArrayList<String>>();
		
		while(rs.next()) {
			ArrayList<String> tuple = new ArrayList<String>();
			
			tuple.add(rs.getString(1));
			tuple.add(rs.getString(2));
			tuple.add(rs.getString(3));
			tuple.add(rs.getString(4));
			tuple.add(rs.getString(5));
			model.add(tuple);			
		}
		ps.close();		
		return model;		
	}

}
