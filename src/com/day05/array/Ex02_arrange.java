package com.day05.array;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex02_arrange {

	public static void main(String[] args) {
		int cnt=0;
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("데이터를 입력하세요.");
		s = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(s);
		
		cnt=st.countTokens();
		int[] arr = new int[cnt];
		int temp = 0;
		
		for(int i=0;i<cnt;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>temp)
				temp = arr[i];
		}
		
		System.out.println("최대값:"+temp);	
		
		sc.close();
	}

}
