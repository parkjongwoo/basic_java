package com.day01.data;

import java.util.Scanner;

public class Ex07_input3 {

	public static void main(String[] args) {
//		Scanner 클래스의 next(), nextLine()의 차이
		
		Scanner in = new Scanner(System.in);
		
		String s;
		System.out.println("입력->");
		
//		while(in.hasNext()) {
//			s = in.next();
//			System.out.println(s);
//		}
//		
//		while(in.hasNext()) {
//			s = in.nextLine();
//			System.out.println(s);
//		}
//		next()는 공백문자(\0),줄바꿈(\n) 문자가 오면 입력받기를 종료한다
		s = in.next();
		System.out.println(s);
		
//		nextLine()은 공백,줄바꿈을 무시하고 캐리지리턴(\r)이 나올 때 까지 입력받기를 계속 진행한다. 
		s = in.nextLine();
		System.out.println(s);
		
		in.close();
	}

}
