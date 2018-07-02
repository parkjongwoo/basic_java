package com.day09.inherit.q2;

public class ConversationBook extends Book {
	
	String lan;	
	
	public ConversationBook() {
		super();
		values = new String[8];
//		values[0] = id;
//		values[1] = instruction;
//		values[2] = manufacturer;
//		values[3] = price;
//		values[4] = isbnNum;
//		values[5] = writer;
//		values[6] = title;
//		values[7] = lan;
		
		inputList = new String[8];
		inputList[0] = "상품ID";
		inputList[1] = "상품 설명";
		inputList[2] = "생산자";
		inputList[3] = "가격";
		inputList[4] = "isbn";
		inputList[5] = "저자";
		inputList[6] = "책 제목";
		inputList[7] = "언어";
	}
	
//	@Override
//	public String[] getInputList() {
//		return new String[]{"상품 설명","생산자","가격","isbn","저자","책 제목","언어"};
//	}

	
//	@Override
//	public void showInfo() {
//		// TODO Auto-generated method stub
//		
//	}

}
