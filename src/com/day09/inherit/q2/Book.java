package com.day09.inherit.q2;

public class Book extends Product {
	
	String isbnNum;
	String writer;
	String title;
	
	public Book() {
		super();
		values = new String[7];
//		values[0] = id;
//		values[1] = instruction;
//		values[2] = manufacturer;
//		values[3] = price;
//		values[4] = isbnNum;
//		values[5] = writer;
//		values[6] = title;
		
		inputList = new String[7];
		inputList[0] = "상품ID";
		inputList[1] = "상품 설명";
		inputList[2] = "생산자";
		inputList[3] = "가격";
		inputList[4] = "isbn";
		inputList[5] = "저자";
		inputList[6] = "책 제목";
	}
	
//	@Override
//	public String[] getInputList() {
//		return new String[]{"상품 설명","생산자","가격","isbn","저자","책제목"};
//	}

//	@Override
//	public void showInfo() {
//		StringBuffer sb = new StringBuffer();
//		
//		System.out.println(sb);
//	}

}
