package com.day09.inherit.test;

import java.util.Scanner;

public abstract class Product {
	/**
	 * 상품의 입력 정보 명칭의 목록
	 */
	protected String[] keyList;
	/**
	 *  상품의 입력 정보 값의 목록
	 */
	protected String[] valueList;
	
	/**
	 * 상품 정보 저장 추상 클래스. 입력, 출력을 구현하고 
	 * 데이터를 추상화하여 구현 클래스에서 데이터만 지정
	 */
	public Product() {
		keyList = getProductProperties();//자식 Class에서 입력 정보 반환
		valueList = new String[keyList.length];//입력 정보 개수에 맞춰 값 저장소 초기화
	}
	
	/**
	 * 저장된 입력 정보 명칭 배열에 맞춰 값을 입력 받음.
	 * @param index 상품번호. 입력된 순번.
	 * @param sc 입력을 위한 Scanner 객체. 출력시 애러 방지.
	 */
	public void inputData(int index, Scanner sc) {
		valueList[0] = String.valueOf(index);// 상품ID 저장
		for(int i=1;i<keyList.length;i++) {// 입력 정보 명칭 목록의 개수만큼 반복
			System.out.println(keyList[i]+">>");// 입력 프롬프트 출력. 상품설명, 생산자, 가격정보,...
			valueList[i] = sc.nextLine();// 입력한 값을 저장
		}
	}
	
	/**
	 * 저장된 상품 정보를 출력
	 */
	public void showInfo() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<keyList.length;i++) {// 입력 정보 명칭 목록의 개수만큼 반복
			sb.append(keyList[i]).append(">>").append(valueList[i]).append('\n');// "입력명칭>>입력값 줄바꿈"형식으로 문자열 생성
		}
		System.out.println(sb);//생성한 문자열 출력
	}
	
	/**
	 * 각 상품의 입력 정보 명칭 목록을 구현 Class에서 반환하도록 추상 메소드로 지정.
	 * @return 구현한 Product Class의 입력 정보 명칭 목록을 String[]으로 반환.
	 */
	public abstract String[] getProductProperties();
}
