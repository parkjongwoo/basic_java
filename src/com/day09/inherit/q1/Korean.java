package com.day09.inherit.q1;

public class Korean extends Language {
	int a= 1;
	int get() {return a;}
	@Override
	String g() {
		// TODO Auto-generated method stub
		return "안녕";
	}

	@Override
	String i() {
		// TODO Auto-generated method stub
		return "난 나야";
	}

	@Override
	String h() {
		// TODO Auto-generated method stub
		return "배고파";
	}
	
//	@Override
//	String getSentence(char type) {
//		String output;
//		switch(type) {
//		case '2':
//			output = "내가 낸대.";
//			break;
//		case '3':
//			output = "배를 째라.";
//			break;
//		default:
//			output = "안녕하세요.";
//		}
//		return output;
//	}

}
