package com.day09.inherit.q1;

import java.util.Scanner;

public class MessagePrinter {

	private Scanner sc;

	public MessagePrinter() {
		sc = new Scanner(System.in);
	}
	
	public void a() {
		
	}
	void a(int a) {
		
	}
	public void inputQ1Msg() {
		char goOn = 'Y';
		char lang = '1';
		char type = '1';
		String sentence;
		Language l;
		do {
			System.out.println("언어를 선택하세요(1.한국어 2.영어 3.일본어)");
			lang = sc.nextLine().charAt(0);
			switch (lang) {
			case '2':
				l = new English();
				break;
			case '3':
				l = new Japanease();
				break;
			default:
				l = new Korean();	
			}
			System.out.println("메세지를 선택하세요(1.인사말 2.자기소개 3.하고픈말)");
			type = sc.nextLine().charAt(0);
			
			switch (type) {
			case '2':
				sentence = l.i();
				break;
			case '3':
				sentence = l.h();
				break;
			default:
				sentence = l.g();
			}
			System.out.println(sentence);
			
			System.out.println("다시 하시겠습니까(Y/N)?");
			goOn = sc.nextLine().charAt(0);
		} while (goOn == 'Y' || goOn == 'y');
	}
}
