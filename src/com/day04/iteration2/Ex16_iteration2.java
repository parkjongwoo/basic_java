package com.day04.iteration2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex16_iteration2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int value = 0;// 새 값
		int value2 = 0;// 이전 값
		
		System.out.println("두 값을 입력하세요.(0이 없으며, 같지 않은 두 수)");
		sb.append(sc.nextLine());// 입력값 저장
		sb.reverse(); // 값 반전
		StringTokenizer st = new StringTokenizer(sb.toString());
		
		while(st.hasMoreTokens()) {// 입력값 반복
			value = Integer.parseInt(st.nextToken());// 이번 입력값 저장
			value2 = value2<value?value:value2;// 이전 값과 이번값 비교
		}
		System.out.println(value2);
		
		sc.close();
	}

}
