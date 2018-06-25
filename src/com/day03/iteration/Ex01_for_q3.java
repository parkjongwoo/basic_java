package com.day03.iteration;

import java.util.Scanner;

public class Ex01_for_q3 {

	public static void main(String[] args) {
//		문제3 ) 입력받은 문자열의 뒤집어서 출력하세요
//	  
//		[예]  입력     출력
//	   
//	   		안녕 친구   구친 녕안
//	   		CarpeDiem   meiDepraC
		
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int lng;
		char c;
		int center;
		System.out.println("문자열을 입력하세요.");
		
		for(int i=0;i<10000;i++) {
			sb.append((char)('a'+(i%24)));
		}
		
		
		lng =  sb.length();
		long currentTime = System.currentTimeMillis();
		for(int i=lng-1;i>=0;i--) {
			System.out.print(sb.charAt(i));
		}
		System.out.print('\n');
		System.out.println("print only for elapsed time: "+(System.currentTimeMillis()-currentTime));
		
		currentTime = System.currentTimeMillis();
		System.out.println(sb.reverse());
		System.out.println("reverse elapsed time: "+(System.currentTimeMillis()-currentTime));
		
		center = lng/2;
		currentTime = System.currentTimeMillis();
		for(int i=0;i<center;i++) {
			c = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(lng-i-1));
			sb.setCharAt(lng-i-1,c);
		}
		System.out.println(sb);
		System.out.println("change for elapsed time: "+(System.currentTimeMillis()-currentTime));
		sc.close();
	}

}
