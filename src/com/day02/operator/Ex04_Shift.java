package com.day02.operator;

public class Ex04_Shift {
	public static void main(String[] args) {
		// << 비트를 좌측으로 이동:우측에 채울 비트는 0으로 채움
		// >> 비트를 우측으로 이동: 좌측 채울 비트는 1로 채움
		// >>> 비트를 우측으로 이동: 좌측 채울 비트는 0으로 채움, 결과적으로 비트가 삭제됨. 
		int a= -4;
		System.out.println("a:\t"+Integer.toBinaryString(a));
		System.out.println("a<<2:\t"+Integer.toBinaryString(a<<2));
		
		System.out.println("a>>2:\t"+Integer.toBinaryString(a>>2));
		
		System.out.println("a>>>2:\t"+Integer.toBinaryString(a>>>2));
		
	}
}
