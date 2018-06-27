package com.day06.method;

import java.util.Scanner;

public class Ex08_method_exq1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자를 입력받아 더하기 1하여 출력. 숫자에는 0이 들어갈 수 없다.
		
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		long value;//입력받을 숫자저장
		int c = 0;//문자 코드처리
		
		System.out.println("숫자를 입력하세요.");
		value = sc.nextLong();//숫자입력 저장
		value++;//1더하기
		sb.append(String.valueOf(value));//문자열로 변환
		
		for(int i=0;i<sb.length();i++) {
			c = sb.charAt(i);//자리의 숫자 저장
			if(c == '0') {//0이면
				sb.setCharAt(i, '1');//1로 변경
			}
		}
		
		System.out.println(sb);
		sc.close();
	}

}
