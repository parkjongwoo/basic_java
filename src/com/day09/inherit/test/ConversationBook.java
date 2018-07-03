package com.day09.inherit.test;

public class ConversationBook extends Book {

	public ConversationBook() {}

	@Override
	public String[] getProductProperties() {
		//ConversationBook 상품의 입력 정보의 명칭 목록
		return new String[]{"상품ID","상품 설명","생산자","가격","ISBN","저자","제목","언어명"};
	}
	
}
