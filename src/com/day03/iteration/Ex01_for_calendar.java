package com.day03.iteration;

import java.util.Calendar;
import java.util.Locale;

public class Ex01_for_calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		
		cal.set(Calendar.DATE, 1);
		int dayOfFirst = cal.get(Calendar.DAY_OF_WEEK);
		int lastDateOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int date = 1;
		
		sb.append("\t\t\t").append(cal.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.getDefault())).append('\n').
		append("일\t").append("월\t").append("화\t").append("수\t").append("목\t").append("금\t").append("토\n");
		
		for(int i=1;i<=35;i++) {			
			if(date>1 || dayOfFirst == i) {
				sb.append(date);
				date++;
			}
			
			if(i%7==0)
				sb.append('\n');
			else
				sb.append('\t');
				
			if(date>lastDateOfMonth)
				break;			
		}
		
		System.out.println(sb);
	}
}
