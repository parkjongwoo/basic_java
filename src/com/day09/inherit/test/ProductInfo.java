package com.day09.inherit.test;

import java.util.Scanner;

public class ProductInfo {

	public static void main(String[] args) {
		char howDo = ' ';//어느 작업을 할지 입력 받은 문자 저장
		int whatDo = ' ';//무엇을 입력할지 입력 받은 문자 저장
		int idx = 0;//몇 번째 위치에 입력하는지 배열 위치 저장 
		Product[] plist = new Product[5];//추가할 상품 정보를 저장
		Scanner sc = new Scanner(System.in);//입력 문자 저장
		//각 상품 구현 클래스를 배열 저장해서 switch~case 사용하지 않도록 코드 작성
		Class<?>[] c = new Class[] {Book.class, CompactDisc.class, ConversationBook.class};
		
		ROOT:
		while (true) {//끝내기 선택할 때까지 무한 반복
			System.out.println("상품 추가(1), 모든 상품 조회(2), 끝내기(3)");//첫 메뉴
			howDo = sc.nextLine().charAt(0);//작업 종류 저장
			switch (howDo) {// 작업 종류에 따라
			case '1':// 1이면 저장 작업 시작
				if(idx>=5) {//상품 저장 개수는 5개가 최대이므로 위치가 5이상이면 추가 저장 불가 
					System.out.println("더 이상 추가할 수 없습니다.");
					continue;// 첫 메뉴로 복귀
				}
					
				System.out.println("상품 종류 책(1), 음악CD(2), 회화책(3)");//저장 상품 종류 선택
				whatDo = Character.getNumericValue(sc.nextLine().charAt(0)-1);//상품 종류 저장. 상품Class 배열 인덱스에 맞춰 0~2값으로 조정.
				if(whatDo<0 || whatDo>2) {//상품 종류를 1~3이 아닌 값으로 선택하면  
					System.out.println("입력 불가능한 상품 종류입니다.");
					continue;// 첫 메뉴로 복귀
				}
				try {
					plist[idx] = (Product) c[whatDo].newInstance();//저장해둔 상품Class 배열로 새 상품 객체 생성.
				} catch (Exception e) {// 예외 처리
					e.printStackTrace();
					continue;
				}
				plist[idx].inputData(idx, sc);//Product에 정의해 놓은 데이터 저장 절차 진행
				idx++;//다음 저장 위치로 변경
				break;
			case '2':// 2이면 입력 받은 전체 상품 정보 출력
				for(int i=0;i<idx;i++) {//입력받은 상품정보 수만큼 반복
					if(plist[i] == null) break;//입력정보가 없는 경우라면 출력 취소
					plist[i].showInfo();//Product에 정의해 놓은 데이터 출력 절차 진행
				}
				break;
			case '3':// 3이면 종료
				break ROOT;//무한 반복 종료
			}			
		}
		sc.close();
	}
}
