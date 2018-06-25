package com.day02.operator;

import java.util.Scanner;

public class Ex07_ {

	public static void main(String[] args) {
		// 문자를 한글자 입력받아 대문자인지 소문자인지 출력
		
		Scanner sc = new Scanner(System.in);
		char charCode;
		
		System.out.println("문자를 입력하세요.");
		
		charCode = (char)sc.nextLine().charAt(0);
		
		if(charCode >= 'A' && charCode <= 'Z')
		{
			System.out.println(charCode+"는 대문자입니다.");
		}else if(charCode >= 'a' && charCode < 'z') {
			System.out.println(charCode+"는 소문자입니다.");
		}else {
			System.out.println(charCode+"는 알파벳이 아닙니다.");
		}
		
		sc.close();
	}

}
