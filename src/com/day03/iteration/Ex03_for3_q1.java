package com.day03.iteration;

import java.util.Scanner;

public class Ex03_for3_q1 {

	public static void main(String[] args) {
		int wid;
		int hei;
		int cnt=1;
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("넓이,높이를 입력하세요.");
		wid = sc.nextInt();
		hei = sc.nextInt();
		
		for(int i=0;i<hei;i++) {
			for(int j=0;j<wid;j++) {
				sb.append(cnt).append('\t');
				cnt++;				
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		sc.close();
	}

}
