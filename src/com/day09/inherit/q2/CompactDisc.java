package com.day09.inherit.q2;

public class CompactDisc extends Product {
	
	String title;
	String singer;
	
	public CompactDisc() {
		super();
		values = new String[6];
//		values[0] = id;
//		values[1] = instruction;
//		values[2] = manufacturer;
//		values[3] = price;
//		values[4] = title;
//		values[5] = singer;
		
		inputList = new String[6];
		inputList[0] = "상품ID";
		inputList[1] = "상품 설명";
		inputList[2] = "생산자";
		inputList[3] = "가격";
		inputList[4] = "앨범 제목";
		inputList[5] = "가수";
	}
//	@Override
//	public String[] getInputList() {
//		return new String[]{"상품 설명","생산자","가격","앨범 제목","가수"};
//	}
//	
//	@Override
//	public void showInfo() {
//		// TODO Auto-generated method stub
//
//	}

}
