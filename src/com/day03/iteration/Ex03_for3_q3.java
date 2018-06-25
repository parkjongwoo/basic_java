package com.day03.iteration;

import java.util.Scanner;

public class Ex03_for3_q3 {

	public static void main(String[] args) {
		int wid;
		int hei;
		int cnt=1;
		int add=1;
		
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("넓이,높이를 입력하세요.");
		wid = sc.nextInt();
		hei = sc.nextInt();
		
		for(int i=1;i<=hei;i++) {
			cnt = i%2==0?i*wid:i*wid-wid+1;
			for(int j=1;j<=wid;j++) {
				sb.append(cnt).append('\t');
				cnt+=add;				
			}
			add*=-1;
			sb.append('\n');
		}		
		
		System.out.println(sb);
		sc.close();		
	}
}
