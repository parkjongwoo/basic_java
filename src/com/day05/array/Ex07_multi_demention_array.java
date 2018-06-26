package com.day05.array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex07_multi_demention_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//여러 학생의 국영수 입력받아 총/평균 출력
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int num = 0;
		
		System.out.println("입력할 학생수를 입력하세요.");
		num = sc.nextInt();
		
		int[][] score = new int[num][3];//학생수만큼 점수 배열 생성
		int[][] tot=new int[num][2];//학생수만큼 총점 배열생성
		double[][] avg=new double[num][2];//학생수만큼 평균 배열생성
		int subCnt = 0;
		String[] subNames = {"국어","영어","수학"};
		
		sc.nextLine();//남는 엔터 제거
		for(int i=0;i<score.length;i++) {//학생수 루프
			System.out.println((i+1)+"번째 학생의 성적을 입력하세요.");			
			st = new StringTokenizer(sc.nextLine());
			subCnt = st.countTokens();
			for(int j=0;j<subCnt;j++) {// 과목수 루프			
				score[i][j] = Integer.parseInt(st.nextToken());//점수입력
				tot[i][0]+=score[i][j];//총점 산정
			}
			avg[i][0] = (double)tot[i][0]/score[i].length;//평균 산정
		}
		
		for(int i=0;i<subCnt;i++) {//과목수 루프
			for(int j=0;j<score.length;j++) {// 학생수 루프				
				tot[i][1]+=score[j][i];//총점 산정
			}
			avg[i][1] = (double)tot[i][1]/score.length;//평균 산정
		}
		
		for(int i=0;i<score.length;i++)//학생수 루프
			System.out.println((i+1)+"번째 학생의 총점은 "+tot[i][0]+"점 이고 평균은 "+avg[i][0]+"점 입니다.");
		
		for(int i=0;i<subCnt;i++)//과목수 루프
			System.out.println(subNames[i]+"의 총점은 "+tot[i][1]+"점 이고 평균은 "+avg[i][1]+"점 입니다.");
		
		sc.close();
	}

}
