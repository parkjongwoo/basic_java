package com.day04.iteration2;

public class Ex15_iteration {

	public static void main(String[] args) {
		int max = 10000;// 마지막 수
		int cnt = 0;// 갯수
		String s;// 숫자를 문자열 변환 저장
		for(int i=1;i<=max;i++) {// 마지막 수까지 반복
			s = String.valueOf(i);// 문자열로 변환
			int ciper = s.length();// 자릿수 계산
			for(int j=0;j<ciper;j++) {// 자릿수 만큼 반복
				if(s.charAt(j)=='8')//8 문자가 있으면 추가
					cnt++;
			}
		}
		
		System.out.println("1~10000 중에서 8의 갯수는 "+cnt);		
	}
}
