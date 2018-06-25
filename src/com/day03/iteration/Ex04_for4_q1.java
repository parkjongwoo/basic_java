package com.day03.iteration;

import java.util.Scanner;

public class Ex04_for4_q1 {

	public static void main(String[] args) {
		int cint='A';
		int n=0;
		int wid;
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("6이하의 숫자를 입력하세요.");
			wid = sc.nextInt();
			
			if(wid<=6)
				break;
			
		}while(true);
		
		for(int i=0;i<wid;i++) {
			for(int j=0;j<wid;j++) {
				if(j<wid-i) {
					sb.append((char)cint).append('\t');
					cint++;
				}else {
					sb.append(n).append('\t');
					n++;
				}				
			}
			sb.append('\n');
		}
		System.out.println(sb);
		sc.close();
	}

}
