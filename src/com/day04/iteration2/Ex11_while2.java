package com.day04.iteration2;

import java.util.Scanner;

public class Ex11_while2 {

	public static void main(String[] args) {
		int tot = 0;
		int value = 0;
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("10개의 정수를 입력하세요.0 입력시 입력 종료합니다.");
		
		int cnt=1;
		while(cnt<=10) {
			value = sc.nextInt();
			
			if(value==0)
				break;
			
			tot += value;
			
			cnt++;
		}
		cnt--;
		sb.append("합계: ").append(tot).append('\n').
		append("평균: ").append(tot/cnt);
		
		System.out.println(sb);
		
		sc.close();
	}

}
