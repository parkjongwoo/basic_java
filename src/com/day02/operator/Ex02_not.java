package com.day02.operator;

public class Ex02_not {
	public static void main(String[] args) {
//		not 연산자: 값을 반대로 전환하는 연산자
//		일반 논리연산자: !  true > false, false > true 로 변환
//		이진 논리연산자: ~  값을 이진표현으로 생각하여 1 > 0, 0 > 1 로 변환
		int i = 4;//00000000 00000000 00000000 00000100
		System.out.println("i:"+i);
		
		i = ~i;//11111111 11111111 11111111 11111011 
		System.out.println("i:"+i);
		
		int j = 4;
		System.out.println("j:"+j);
		
//		j = !j; //boolean 타입으로 변경되므로 컴파일 애러발생
//		System.out.println("j:"+j);
	}
}
