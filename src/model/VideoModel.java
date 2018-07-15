package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Genre;
import model.vo.Movie;
import model.vo.Video;

public class VideoModel {
	
	/**
	 * 디비 컨넥션
	 */
	Connection con;
	
	/**
	 * 장르 목록.
	 */
	public ArrayList<Genre> genreList;
	
	public VideoModel() throws Exception {

		// 1. 드라이버 로딩
		// 2. Connection 객체 얻어오기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. Connection 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, password);
		loadgenre();
	}
	
	/**
	 * 새로운 비디오 추가. 먼저 영화테이블에 영화 입력. 입력한 영화테이블의 현재시퀀스값을 외래키로 비디오 입력. 
	 * 타이틀,감독 값 고유값 위배가 발생한 경우 해당 영화의 번호로 비디오 입력.
	 * @param dao 비디오 정보
	 * @param count 추가할 재고 수
	 * @throws Exception sql 관련 예외.
	 */
	public void insertVideo(Video dao, int count) throws Exception {
		// 3. sql 문장 만들기
		// 4. sql 전송객체(PreparedStatement)
		// 5. sql 전송
		// 6. 닫기(PreparedStatement만 닫기)
		int result = insertMovie(Movie.createMovieFromVideo(dao));
		
		if(result>0) {
			// 영화 입력 완료. 비디오 입력시작
			insertMultipleVideoByDBSeqCurrval(count);
		}else if(result==-1) {
			//영화제목,감독이 같은 영화가 이미 있음. 해당 영화 검색해서 키값 받아서 처리.
			insertMultipleVideoByTitleAndVideo(dao.getVideoName(),dao.getDirector(), count);
		}else {
			// 위의 영화 입력 함수에서 예외발생해서 실행되지 않는 조건.
		}
		System.out.println("비디오 생성 작업 완료.");
	}
	
	/**
	 * 새로 입력된 영화번호로 비디오 생성
	 * @param count 생성 갯수
	 * @throws Exception sql
	 */
	private void insertMultipleVideoByDBSeqCurrval(int count) throws Exception  {
		String sql = "INSERT INTO V_VIDEO (vid,mid) "
				+ " VALUES (seq_vid.NEXTVAL,seq_mid.CURRVAL)";
		PreparedStatement ps = con.prepareStatement(sql);
		for(int i=0;i<count;i++) {
			ps.executeUpdate();					
		}
		ps.close();
		System.out.println("새로 입력한 영화로 비디오 ["+count+"]개 입력완료.");
	}
	
	/**
	 * 기존 영화를 제목, 감독으로 검색해서 해당 번호로 비디오 추가
	 * @param title 영화제목
	 * @param director 영화감독
	 * @param count 생성 갯수
	 * @throws Exception sql
	 */
	private void insertMultipleVideoByTitleAndVideo(String title,String director, int count) throws Exception  {
		String sql = "INSERT INTO V_VIDEO (vid,mid) "
				+ " VALUES (seq_vid.NEXTVAL, "
				+ " (SELECT mid FROM v_movie WHERE mtitle=? and mdir=?))";
		PreparedStatement ps = con.prepareStatement(sql);		
		ps.setString(1, title);		
		ps.setString(2, director);	
				
		for(int i=0;i<count;i++) {
			ps.executeUpdate();					
		}
		ps.close();
		System.out.println("기존의 제목["+title+"] 감독["+director+"]인 영화로 비디오 ["+count+"]개 입력완료.");
	}
	
	/**
	 * dao 정보로 영화 추가.
	 * @param dao 영화 정보
	 * @return 입력결과 1 이상: 입력완료, -1:기존 제목,감독 동일 영화있음.
	 * @throws Exception sql제외한 예외
	 */
	private int insertMovie(Movie dao) throws Exception{
		int result=0;
		String sql = "INSERT INTO V_MOVIE (mid,genid,mtitle,mdir,mact,mdis) "
				+ " VALUES (seq_mid.NEXTVAL,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dao.getGenre());
			ps.setString(2, dao.getMovieName());
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
	/**
	 * 장르 불러오기
	 * @throws Exception sql
	 */
	public void loadgenre() throws Exception{
		String sql = "SELECT * FROM v_genre";
		PreparedStatement ps = con.prepareStatement(sql);		
		genreList = new ArrayList<Genre>();
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Genre dao = new Genre();
			dao.setGenid(rs.getString(1));
			dao.setGenname(rs.getString(2));
			genreList.add(dao);
		}
		ps.close();
		System.out.println("장르로딩 성공:"+genreList.toString());
	}
	
	public int deleteVideo(int videoNo) throws Exception{
		System.out.println(videoNo+"번 비디오 삭제");
		int result = 0;
		String sql = "DELETE FROM v_video WHERE vid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, String.valueOf(videoNo));
		result = ps.executeUpdate();
		ps.close();
		return result;
		
	}

	public int updateMovie(Movie dao) throws Exception{
		int result=0;
		String sql = "UPDATE V_MOVIE SET"
				+ " genid=?, mtitle=?, mdir=?, mact=?, mdis=? "
				+ " WHERE mid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dao.getGenre());
		ps.setString(2, dao.getMovieName());
		ps.setString(3, dao.getDirector());
		ps.setString(4, dao.getActor());
		ps.setString(5, dao.getExp());
		ps.setString(6, String.valueOf(dao.getMovieNo()));
		result = ps.executeUpdate();
		ps.close();
		return result;
	}
	
	/**
	 * 제목으로 영화 검색
	 * @param text 제목
	 * @return ArrayList<ArrayList<Video>> 영화정보를 튜플로 구성한 2차원 리스트.
	 * @throws Exception sql
	 */
	public ArrayList<Video> searchVideoByTitle(String text) throws Exception {
		String sql = "SELECT v.vid, m.mtitle, g.genname, m.mdir, m.mact, m.mdis, m.mid FROM v_video v INNER JOIN v_movie m"
				+ " ON m.mid=v.mid "
				+ " INNER JOIN v_genre g "
				+ " ON m.genid=g.genid "
				+ " WHERE m.mtitle LIKE ? "
				+ " ORDER BY v.vid";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+text.trim()+"%");
		ResultSet rs = ps.executeQuery();
		ArrayList<Video> model = new ArrayList<Video>();
		
		while(rs.next()) {
			Video tuple = new Video();
			
			tuple.setVideoNo(rs.getInt(1));
			tuple.setVideoName(rs.getString(2));
			tuple.setGenre(rs.getString(3));
			tuple.setDirector(rs.getString(4));
			tuple.setActor(rs.getString(5));
			tuple.setExp(rs.getString(6));
			tuple.setMovieNo(Integer.parseInt(rs.getString(7)));
			model.add(tuple);			
		}
		ps.close();	
		System.out.println("제목으로 비디오 검색 성공");
		return model;		
	}
	
	/**
	 * 감독으로 영화 검색
	 * @param text 감독이름
	 * @return ArrayList<ArrayList<Video>> 영화정보를 튜플로 구성한 2차원 리스트.
	 * @throws Exception sql
	 */
	public ArrayList<Video> searchVideoByDirector(String text) throws Exception  {
		String sql = "SELECT v.vid, m.mtitle, g.genname, m.mdir, m.mact, m.mdis, m.mid FROM v_video v INNER JOIN v_movie m"
				+ " ON m.mid=v.mid "
				+ " INNER JOIN v_genre g "
				+ " ON m.genid=g.genid "
				+ " WHERE m.mdir LIKE ? "
				+ " ORDER BY v.vid";	
		
		PreparedStatement ps = con.prepareStatement(sql);		
		ps.setString(1, "%"+text.trim()+"%");
		ResultSet rs = ps.executeQuery();
		ArrayList<Video> model = new ArrayList<Video>();
		
		while(rs.next()) {
			Video tuple = new Video();
			
			tuple.setVideoNo(rs.getInt(1));
			tuple.setVideoName(rs.getString(2));
			tuple.setGenre(rs.getString(3));
			tuple.setDirector(rs.getString(4));
			tuple.setActor(rs.getString(5));
			tuple.setExp(rs.getString(6));
			tuple.setMovieNo(Integer.parseInt(rs.getString(7)));
			model.add(tuple);			
		}
		ps.close();
		System.out.println("감독으로 비디오 검색 성공");
		return model;		
	}
	
	public int getGenreIndex(String genreName) {
		int index = 0;
		
		for(int i=0;i<genreList.size();i++) {
			if(genreList.get(i).getGenname().equals(genreName))
				index = i;
		}
		
		return index;
	}
}
