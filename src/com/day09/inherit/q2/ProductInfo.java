package com.day09.inherit.q2;

import java.util.Scanner;

public class ProductInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product[] pArr = new Product[5];
		Scanner sc = new Scanner(System.in);
		int productNum = 0;
		
		char selectionMain = ' ';
		char selectionType = ' ';
		do {
			
			System.out.println("상품추가(1), 모든 상품 조회(2), 끝내기(3)>>");
			selectionMain = sc.nextLine().charAt(0);
			
			switch (selectionMain) {
			case '1':
				if(productNum>=5)
				{
					System.out.println("더 이상 추가할 수 없습니다.");
					continue;
				}
				System.out.println("상품 종류 책(1), 음악CD(2), 회화책(3)>>");
				selectionType = sc.nextLine().charAt(0);
				switch(selectionType) {
				case '1':
					pArr[productNum] = new Book();
					break;
				case '2':
					pArr[productNum] = new CompactDisc();
					break;
				case '3':
					pArr[productNum] = new ConversationBook();
					break;
				}
				pArr[productNum].inputInfo(productNum, sc);
				productNum++;
				break;
			case '2':
				for(int i=0;i<productNum;i++) {
					pArr[i].showInfo();
				}
				break;
			case '3':
				
				break;
			}
			
		}while(selectionMain!='3');
		
	}

}
