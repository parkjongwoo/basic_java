package com.day06.method;

import java.util.Scanner;

public class Ex08_method_exq1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자를 입력받아 더하기 1하여 출력. 숫자에는 0이 들어갈 수 없다.		
		Scanner sc = new Scanner(System.in);
		long value;//입력받을 숫자저장		
		
		System.out.println("숫자를 입력하세요.");
		value = solution(sc.nextLong());		
		
		System.out.println(value);
		sc.close();
	}
	
	static long solution(long num) {
		char c;
		StringBuffer sb = new StringBuffer();
		num++;//1더하기
		sb.append(String.valueOf(num));//문자열로 변환
		
		for(int i=0;i<sb.length();i++) {
			c = sb.charAt(i);//자리의 숫자 저장
			if(c == '0') {//0이면
				sb.setCharAt(i, '1');//1로 변경
			}
		}
		num = Long.parseLong(sb.toString());
		return num;
	}
}
