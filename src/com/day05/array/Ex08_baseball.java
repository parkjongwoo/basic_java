package com.day05.array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex08_baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		int[] answer = new int[3];
		int question = 0;
		int ball = 0;
		int strike = 0;		
		StringTokenizer st;
		int qCnt=5;
		
		// 대답 작성
		for(int i=0;i<answer.length;i++) {
			answer[i] = (int)(Math.random()*10);
			for(int j=0;j<i;j++) {
				if(answer[j]==answer[i]) {
					i--;
					break;
				}					
			}
		}
		
		//qCnt 값 만큼 질문 가능
		for(int i=0;i<qCnt;i++) {
			System.out.println("세 값을 입력하세요.");
			st = new StringTokenizer(sc.nextLine());
			int valuecnt = st.countTokens();
			
			//입력 수만큼 반복
			for(int j=0;j<valuecnt;j++) {
				//입력 수 형변환
				question = Integer.parseInt(st.nextToken());
				
				//정답 갯수 반복
				for(int k=0;k<answer.length;k++) {
					if(answer[k]==question) {//맞는 숫자가 있는 경우
						if(k == j) {//자리도 맞으면
							strike++;
						}else {//자리가 다르면
							ball++;
						}
					}
				}				
			}
			if(strike==3) {//3스트라이크
				System.out.println("정답입니다.");
				break;
			}else if(strike==0 && ball==0){//아웃
				System.out.println("out");
			}else {//볼,스트라이크가 있는 경우
				System.out.println(strike+" strike "+ball+" ball");
			}
			
			strike=0;
			ball=0;
		}
		
		System.out.print("정답은 ");
		for(int i=0;i<answer.length;i++)
			System.out.print(answer[i]+" ");
		
		sc.close();
	}

}
