package com.day05.array;

import java.util.Scanner;

public class Ex01_array {

	public static void main(String[] args) {
		// 학생수를 입력받아 총점, 평균을 출력하라
		
		int cnt=0;
		int tot=0;
		double avg=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 수를 입력하세요.");
		
		cnt = sc.nextInt();
		
		int scores[] = new int[cnt];
		
		for(int i=1;i<=cnt;i++) {
			System.out.println("학생 "+i+"의 국어점수를 입력하세요.");
			scores[i] = sc.nextInt();
			tot += scores[i];			
		}
		
		avg = (double)tot / cnt;
		
		System.out.println("총점: "+tot+" 평균: "+avg);
		
		sc.close();
	}

}
