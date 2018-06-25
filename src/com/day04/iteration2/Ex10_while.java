package com.day04.iteration2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex10_while {

	public static void main(String[] args) {
		//정수 여러개를 입력, 홀수,짝수 개수를 출력
		String s;
		StringBuffer sb = new StringBuffer();
		
		int value=0;
		int odd=0;
		int even=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 여러개를 입력하세요.");
		
		s = sc.nextLine();		
		StringTokenizer st = new StringTokenizer(s);
		
		while(st.hasMoreTokens()) {
			value = Integer.parseInt(st.nextToken());
			if(value%2==0)
				even++;
			else
				odd++;
		}
		sb.append("짝수: ").append(even).append('\n').
		append("홀수: ").append(odd);
		
		System.out.println(sb);
		sc.close();
	}

}
