package com.day06.array;

public class Ex01_dynamic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] chars = new char[4][];
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<chars.length;i++) {
			chars[i] = new char[i+1];
			for(int j=0;j<i+1;j++) {
				chars[i][j]='*';
			}
		}
		
		for(int i=0;i<chars.length;i++) {
			for(int j=0;j<i+1;j++) {
				sb.append(chars[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
