package com.day05.array;

import java.util.Scanner;

public class Ex10_ox_question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String result;
		int thisScore=0;
		int cnt=0;
		int tot=0;
		int qCnt=0;
		
		System.out.println("몇 번 합니까?");
		qCnt = sc.nextInt();
		sc.nextLine();
		
		System.out.println("퀴즈 결과를 입력하세요.(OX)");
		
		
		for(int j=0;j<qCnt;j++) {
			result = sc.nextLine();
			//글자수 산정
			cnt=result.length();
			for(int i=0;i<cnt;i++) {//글자수 반복
				switch(result.charAt(i)) {
				case 'O':
				case 'o'://글자가 O,o인 경우
					thisScore++;//점수 상승
					break;
				default://나머지 글자인 경우
					thisScore=0;	// 점수 초기화
				}			
				tot += thisScore;//점수 누적
			}
			System.out.println("퀴즈 결과는 "+ tot +"점 입니다.");
			tot=0;
			thisScore=0;
		}		
		sc.close();
	}
}
