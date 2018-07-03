package com.day09.inherit.test;

public class CompactDisc extends Product {

	public CompactDisc() {}

	@Override
	public String[] getProductProperties() {
		//CompacDisc의 입력 정보의 명칭 목록
		return new String[]{"상품ID","상품 설명","생산자","가격정보","앨범 제목","가수 이름"};
	}

}
