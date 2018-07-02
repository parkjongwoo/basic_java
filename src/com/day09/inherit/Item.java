package com.day09.inherit;

public abstract class Item {
	String no;
	String title;
	public Item() {
		System.out.println("Item 기본 생성자");
	}
	public Item(String no, String title) {
		System.out.println("Item 인자 생성자");
		this.no = no;
		this.title = title;
	}
	
	/**
	 * 출력을 위한 추상 메소드
	 */
	public abstract void output();
}
