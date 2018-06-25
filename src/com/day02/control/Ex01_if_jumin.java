package com.day02.control;

import java.util.Calendar;

public class Ex01_if_jumin {
	public static void main(String[] args) {
		String id = "800621-1234567";
		char zen = id.charAt(7);		
		System.out.println(zen);
		
		//남,여 출력
		
		if(zen == '1' || zen == '3' || zen == '9') {
			System.out.println("남자");
		}else if(zen == '2' ||zen == '0'||zen == '4') {
			System.out.println("여자");
		}
		
		//나이 계산
		String str_b = id.substring(0, 2);
		int int_b = Integer.parseInt(str_b);
		int base = 1900;
		int age_koStyle;
		int age_fullYear;
		
		if(zen == '3' || zen == '4' ) {
			base = 2000;
		}else if(zen == '0' || zen == '9' ) {
			base = 1800;
		}
		
		Calendar today = Calendar.getInstance();
		Calendar birthDay = Calendar.getInstance();
		birthDay.set((base+int_b), (Integer.parseInt(id.substring(2, 4))-1), Integer.parseInt(id.substring(4, 6)));
		
//		System.out.println("today:"+today.toString());
		age_koStyle = today.get(Calendar.YEAR) - (base+int_b) + 1;
		
		age_fullYear = age_koStyle - 1;
				
		if(birthDay.get(Calendar.MONTH) > today.get(Calendar.MONTH)){
			age_fullYear--;
		}else if(birthDay.get(Calendar.MONTH) == today.get(Calendar.MONTH)&&
			birthDay.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)) {
			age_fullYear--;
		}
		
		
		System.out.println("korean age:"+age_koStyle);
		System.out.println("fullyear age:"+age_fullYear);
	}
}
