package com.day09.inherit;

public class Cd extends Item {
	
	private String composer;
	
	public Cd() {
		
	}
	
	public Cd(String no, String title, String composer) {
		this.no = no;
		this.title = title;
		this.composer = composer;
	}

	public void output() {
		System.out.println("번호: "+no);
		System.out.println("제목: "+title);
		System.out.println("작곡자:"+composer);
	}
}
