package com.day01.data;

public class Ex06_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "홍길동";
		StringBuffer sb = new StringBuffer("홍길동");
		
		a = a + "파이팅!!";
//		sb = sb + "파이팅!!";
		sb.append("파이팅!!");
		
		System.out.println(a);
		System.out.println(sb);		
	}

}
