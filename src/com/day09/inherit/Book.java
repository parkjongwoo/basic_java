package com.day09.inherit;

public class Book extends Item{	
	protected String writer;
	protected String publisher;
	
	//클래스 데이터 변경
//	1. 객체 생성 후: setter 필요.
//	2. 객체 생성시(초기화): 생성자에서 지정.
	public Book() {
		System.out.println("Book 기본 생성자");
	}
	
	public Book(String no, String title) {
//		super(no,title);//부모생성자 호출
//		
//		this.writer = "미상";
//		this.publisher = "미상";
		
		this(no,title,"미상","미상");//다른 생성자를 호출해서 반복되는 코드 제거 가능
		System.out.println("Book 일부 인자 생성자");
		
	}
	
	public Book(String no, String title, String writer, String publisher) {
		super(no,title);//부모생성자 호출
		
		this.writer = writer;
		this.publisher = publisher;
		System.out.println("Book 인자 생성자");
	}
	
	@Override
	public void output() {
		System.out.println("번호: "+no);
		System.out.println("제목: "+title);
		System.out.println("작가: "+writer);
		System.out.println("출판사: "+publisher);
		
	}
}
