package com.day04.iteration2;

public class Ex14_break_continue {

	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println("<"+i+","+j+">");
			}
			System.out.println("데이타");
		}
		
		END:
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
//				if(j==1) break END;
				if(j==1) continue END;
				System.out.println("<"+i+","+j+">");				
			}
			System.out.println("데이타");
		}
	}
}
