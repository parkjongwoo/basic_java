package com.day07.oop;

import java.util.Scanner;

public class Ex05_room {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		int[] cnt = new int[10];
		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("방번호를 입력하세요.");
		sb.append(sc.nextLine());//방번호 문자열로 저장
		
		//문자열을 순환하며 숫자패드별로 갯수 산정
		for(int i=0;i<sb.length();i++) {
			cnt[Character.getNumericValue(sb.charAt(i))]++;			
		}
		//6,9 숫자패드 합
		int num69 = cnt[6] + cnt[9];
		//6,9 패드의 합이 짝수면 2로 나눈몫, 아니면 2로 나눈몫+1
		cnt[6] = num69%2==0?num69/2:num69/2+1;
		//6,9는 세트 공유하므로 위의 값으로 변경
		cnt[9] = cnt[6];
		//가장 큰 수 찾기
		for(int i=0;i<cnt.length;i++) {
			if(num<cnt[i])
				num = cnt[i];
		}
		System.out.println("필요한 세트 수는 "+num);
		
		sc.close();
	}

}
