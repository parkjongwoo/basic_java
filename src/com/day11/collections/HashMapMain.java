package com.day11.collections;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("aaaa", "1234");
		map.put("bbbb", "4321");
		map.put("cccc", "5678");
		map.put("dddd", "8765");
		map.put("eeee", "9012");
		
		while(true) {
			System.out.println("아이디->");
			String id = sc.nextLine();
			System.out.println("비밀번호->");
			String pw = sc.nextLine();
			
			if(map.containsKey(id)) {
				if(map.get(id).equals(pw)) {
					System.out.println("로그인 성공");
					break;
				}else {
					System.out.println("비밀번호 일치하지 않음");
					continue;
				}
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
				continue;
			}
		}
		sc.close();
	}

}
