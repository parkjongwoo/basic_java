package com.day04.iteration2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex12_while3_q {

	public static void main(String[] args) {
		//최대값 찾기
		int max=0;
		int value=0;
		String s;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("값을 입력하세요.");
		
		s = sc.nextLine();
		StringTokenizer st = new StringTokenizer(s);
		
		
		while(st.hasMoreTokens()) {
			value = Integer.parseInt(st.nextToken());
			max = max<value?value:max;
		}
		System.out.println("최대값은 "+max+" 입니다.");
		
		sc.close();
	}

}
