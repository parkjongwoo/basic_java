package com.day02.control;

import java.util.HashMap;
import java.util.Map;

public class Ex01_if_hakbun {

	public static void main(String[] args) {
		String collage_id = "1999211";
		
		String year = collage_id.substring(0, 4);
		String collage_key = collage_id.substring(4, 5);
		String major_key = collage_id.substring(5);
		
		Map<String, String> major_en_map = new HashMap<String, String>();
		major_en_map.put("name", "공대");
		major_en_map.put("11", "컴퓨터학과");
		major_en_map.put("12", "소프트웨어학과");
		major_en_map.put("13","모바일학과");
		major_en_map.put("14","자바학과");
		major_en_map.put("15","서버학과");
		
		Map<String, String> major_li_map = new HashMap<String, String>();
		major_li_map.put("name", "사회대");
		major_li_map.put("11", "사회학과");
		major_li_map.put("12", "경영학과");
		major_li_map.put("13", "경제학과");
		
		Map<String, Map<String, String>> collage_map = new HashMap<String, Map<String, String>>();
		collage_map.put("1", major_en_map);
		collage_map.put("2", major_li_map);
		
		try {
			System.out.println(
					collage_id+"는 "+
					year+"년도에 입학한 "+
					collage_map.get(collage_key).get("name")+ " " +
					collage_map.get(collage_key).get(major_key)+" "+
					"학생입니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
