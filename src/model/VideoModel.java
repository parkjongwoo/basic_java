package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import model.vo.Video;

public class VideoModel {

	Connection con;

	public VideoModel() throws Exception {

		// 1. 드라이버 로딩
		// 2. Connection 객체 얻어오기

	}

	public void insertVideo(Video dao, int count) throws Exception {
		// 3. sql 문장 만들기
		// 4. sql 전송객체(PreparedStatement)
		// 5. sql 전송
		// 6. 닫기(PreparedStatement만 닫기)

	}

}
