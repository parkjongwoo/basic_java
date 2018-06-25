package com.day01.data;

public class Ex01_Naming {

	public static void main(String[] args) {
//		규칙
//		1.첫 문자는 영문, $, _ 만 가능하다
		int kor = 0;
		int $eng = 0;
		int _math = 0;
		
//		불가능
//		int 1kor = 0;//첫 글자 숫자
//		int #kor = 0;//$,_이외의 특수문자
		
//		2.첫 문자가 아닌 경우 숫자도 가능하
		int kor3 = 0;
		
//		3.예약어는 사용불가 (예약어: 기본 문법에 사전 정의된 단어)
//		int this = 0;
//		int int = 0;
//		int class = 0;
		
//		4.대소문자를 구분한다.
		int This = 0;//this는 예약어이나 대소문자 구분하므로 This사용가능
		int Integer = 0;//Integer는 java.lang패키지의 클래스이나 예약어가 아님. 사용가능.
		
//		5.길이의 제한이 없다.
		int slkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlfslkdjflskdjflskdjflksjdflkjsdlf = 0;
		
//		6.공백은 사용 불가능하다.
//		int kor score = 0;
		
//		관례
//		1.클래스이름은 대문자 명사
//		TempClass
		
//		2.메서드는 소문자 동사
//		setData
		
//		3.변수는 소문자 명사
//		score_kor
		
//		4.상수는 대문자
//		ENCODING_TYPE
		
	}
}
