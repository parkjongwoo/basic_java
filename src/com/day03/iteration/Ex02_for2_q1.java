package com.day03.iteration;

public class Ex02_for2_q1 {

	public static void main(String[] args) {
		int cint_a = 'A';
		int cint_z = 'Z';
		StringBuffer sb = new StringBuffer();
		
		for(int i=cint_a;i<=cint_z;i++) {
			for(int j=cint_a;j<=i;j++) {
				sb.append((char)j);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
