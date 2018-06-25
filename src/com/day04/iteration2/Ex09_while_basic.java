package com.day04.iteration2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex09_while_basic {

	public static void main(String[] args) {
		 //1-10 합
//		int tot=0;
//		int i=1;
//		for(i=1;i<=10;) {
//			tot+=i;
//			i++;
//		}
//		
//		System.out.println("1-10합: "+tot);
//		
//		tot=0;
//		i=1;
//		while(i<=10) {
//			tot+=i;
//			i++;
//		}
//		System.out.println("1-10합: "+tot);
		
//		Scanner sc = new Scanner(System.in);
//		int dan=0;
//		int cnt=1;
//		int result=0;
//		StringBuffer sb = new StringBuffer();
//		
//		System.out.println("출력할 단수를 입력하세요.");
//		dan = sc.nextInt();
//		
//		while(cnt<10) {
//			result=dan*cnt;
//			
//			sb.append(dan).append('*').append(cnt).
//			append('=').append(result).append('\n');
//			cnt++;
//		}
//		
//		System.out.println(sb);
		
		Scanner sc = new Scanner(System.in);
		StringBuffer msg = new StringBuffer();
		msg.append(sc.nextLine());
		System.out.println(msg);
		
		StringTokenizer st = new StringTokenizer(msg.toString(),"/");
		
//		while(st.hasMoreElements()) {
//			System.out.println(st.nextToken());
//		}
		
		
		int cnt = st.countTokens();
		for(int i=0;i<cnt;i++) {
			System.out.println(st.nextToken());
		}
		sc.close();
	}

}
