package com.day09.inherit.test;

public class Book extends Product {

	public Book() {}

	@Override
	public String[] getProductProperties() {
		//Book 상품의 입력 정보의 명칭 목록
		return new String[]{"상품ID","상품 설명","생산자","가격","ISBN","저자","책 제목"};
	}
	
}
