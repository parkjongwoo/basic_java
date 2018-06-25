package com.day03.iteration;

import java.util.Scanner;

public class Ex01_for_q2 {

	public static void main(String[] args) {
//		문제2)  문자열처리하기
//
//		문자 N(a~z, A~Z)를 입력받아 N이 소문자면 a부터 N까지 인쇄하고 
//		N이 대문자이면 문자 N부터  Z까지 출력하라 
//		그 밖의 문자가 입력되면 Error 를 출력하라
//	
//		입력  출력
//		f       abcdef
//		X       XYZ
//		6       Error
		
		int c;
		int a = (int)'a';
		int z = (int)'z';
		int A = (int)'A';
		int Z = (int)'Z';
		int i;
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영문자 한 글자를 입력하세요.");
		c = (int)(sc.nextLine().charAt(0));
		
		if(a<=c && c<=z) {
			for(i=a;i<=c;i++) {
				sb.append((char)i);
			}
		}else if(A<=c && c<=Z) {
			for(i=c;i<=Z;i++) {
				sb.append((char)i);
			}
		}else {
			sb.append("Error");
		}
		
		System.out.println(sb);
	}

}
