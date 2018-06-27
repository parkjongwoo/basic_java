package com.day06.method;

import java.util.Scanner;

public class Ex06_method_q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(문제 1) 영문자를 입력하여 이 문자가 대문자이면 false을 반환 소문자이면 true을 반환하는 메소드를 작성하시오.
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요.");
		System.out.println(checkLower(sc.nextLine().charAt(0)));
		
		//(문제 2) 영문자를 입력하여 이 문자가 소문자이면 대문자로 변환하여 반환하고 대문자라면 그대로 반환하는 메소드를 작성하시오.
		System.out.println("문자를 입력하세요.");
		System.out.println(checkUpper(sc.nextLine().charAt(0)));
	}
	
	static boolean checkLower(char c) {
		return !(65 <= c && c <=90)&&(97 <= c && c <=122); 
	}
	
	static char checkUpper(char c) {
		return Character.toUpperCase(c); 
	}
}
