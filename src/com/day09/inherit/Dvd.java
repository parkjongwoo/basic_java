package com.day09.inherit;

public class Dvd extends Item {
	
	String director;
	String actor;
	
	public Dvd() {
		super();
	}
	
	public Dvd(String no, String title, String director, String actor) {
		super(no,title);
		
		this.director = director;
		this.actor = actor;
		
		System.out.println("Dvd 인자 생성자");
	}
	
	@Override
	public void output() {
		System.out.println("번호: "+no);
		System.out.println("제목: "+title);
		System.out.println("감독: "+director);
		System.out.println("배우: "+actor);
		
	}
}
