package com.day05.array;

import java.util.Calendar;

public class Ex03_calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] day = new char[] {'일','월','화','수','목','금','토'};
		
		Calendar c = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		//오늘 날짜 요일 출력
		
		sb.append(c.get(Calendar.YEAR)).append("년 ").
		append(c.get(Calendar.MONTH)+1).append("월 ").
		append(c.get(Calendar.DAY_OF_MONTH)).append("일 ").
		append(day[c.get(Calendar.DAY_OF_WEEK)-1]).append("요일 ");
		
		System.out.println(sb);
	}

}
