package com.day02.control;

public class ex01_if_yoonnuen {

	public static void main(String[] args) {
		String result;
		
		for(int i=1900;i<3000;i++) {
			result = "윤년입니다.";
			
			if((i % 4) == 0) {			
				if((i % 100) == 0) {
					if((i % 400) != 0) {
						result = "윤년이 아닙니다.";
					}
				}
			}else {
				result = "윤년이 아닙니다.";
			}
			System.out.println(i+" 년도는 "+result);
		}		
	}
}
