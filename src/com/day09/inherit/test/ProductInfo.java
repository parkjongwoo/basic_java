package com.day09.inherit.test;

import java.util.Scanner;

public class ProductInfo {

	public static void main(String[] args) {
		char howDo = ' ';
		char whatDo = ' ';
		int idx = 0;
		Product[] plist = new Product[5];
		Scanner sc = new Scanner(System.in);
		
		ROOT:
		while (true) {
			System.out.println("상품 추가(1), 모든 상품 조회(2), 끝내기(3)");
			howDo = sc.nextLine().charAt(0);
			switch (howDo) {
			case '1':
				if(idx>=5) {
					System.out.println("더 이상 추가할 수 없습니다.");
					continue;
				}
					
				System.out.println("상품 종류 책(1), 음악CD(2), 회화책(3)");
				whatDo = sc.nextLine().charAt(0);
				
				switch (whatDo) {
				case '1':
					plist[idx] = new Book();
					break;
				case '2':
					plist[idx] = new CompactDisc();
					break;
				case '3':
					plist[idx] = new ConversationBook();
					break;
				}
				plist[idx].inputData(idx, sc);
				idx++;
				break;
			case '2':
				for(int i=0;i<idx;i++) {
					if(plist[i] == null) break;
						plist[i].showInfo();
				}
				break;
			case '3':
				break ROOT;
			}			
		}
		sc.close();
	}

}
