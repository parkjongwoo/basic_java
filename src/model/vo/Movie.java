package model.vo;

public class Movie {
	int movieNo;					// 영화번호
	String genre;				// 장르
	String movieName;			// 비디오명
	String director;				// 감독
	String actor;					// 배우
	String exp;
	
	public static Movie createMovieFromVideo(Video v) {
		Movie m = new Movie();
		m.setMovieNo(v.getMovieNo());
		m.setGenre(v.getGenre());
		m.setMovieName(v.getVideoName());
		m.setDirector(v.getDirector());
		m.setActor(v.getActor());
		m.setExp(v.getExp());
		
		return m;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	
	
}
