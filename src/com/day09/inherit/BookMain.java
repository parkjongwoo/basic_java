package com.day09.inherit;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book("1000","자바책","양씨","생능");
//		b.no = "1000";
//		b.title = "자바책";
//		b.writer = "양씨";
//		b.publisher = "생능";
		b.output();
		
		Book b2 = new Book("1000","자바책");
		b2.output();
		
		Dvd d = new Dvd("2000","마녀","한국인","조민수");
		d.output();
	}

}
